package cn.zhg.test.json.util;

import java.io.*;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*; 
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * 反射工具
 */
public final class ReflectUtil {
	private ReflectUtil() {

	}

	/**
	 * 获取类名称
	 * 
	 * @param clazz  类
	 * @param suffix 后缀
	 * @return
	 */
	public static String getName(Class<?> clazz, String suffix) {
		String name = clazz.getSimpleName();
		return name.substring(0, name.length() - suffix.length());
	}

	/**
	 * 获取maven的版本名称
	 * 
	 * @param clazz 类
	 */
	public static String getMavenVersion(Class<?> clazz) {
		String name = clazz.getName();
		String classPath = "/" + name.replaceAll("\\.", "/") + ".class";
		URL url = clazz.getResource(classPath);
		if (!"jar".equals(url.getProtocol())) {
			return null;
		}
		String urlPath = url.getPath();
		urlPath = urlPath.substring(6, urlPath.lastIndexOf(".jar!")) + ".jar";
		try (ZipFile zipFile = new ZipFile(urlPath);) {
			Enumeration<? extends ZipEntry> entries = zipFile.entries();
			ZipEntry entry = null;
			while (entries.hasMoreElements()) {
				ZipEntry e = entries.nextElement();
				String en = e.getName();
				if (en.startsWith("META-INF/maven/") && en.endsWith("/pom.properties")) {
					entry = e;
					break;
				}
			}
			if (entry == null) {
				return null;
			}
			try (InputStream is = zipFile.getInputStream(entry)) {
				Properties ps = new Properties();
				ps.load(is);
				return ps.getProperty("version");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 加载类
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public static <T> T loadService(Class<T> clazz) {
		Iterator<T> itor = loadServices(clazz);
		if (itor == null) {
			return null;
		}
		return itor.hasNext() ? itor.next() : null;
	}

	public static <T> Iterator<T> loadServices(final Class<T> clazz) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		List<Class<T>> clazzList = new ArrayList<>(); 
		try {
			Enumeration<URL> urls = loader.getResources(".");
			while(urls.hasMoreElements()) {
				URL url = urls.nextElement();
				Path rootPath = Paths.get(url.toURI());
				Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() { 
					@SuppressWarnings("unchecked")
					public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
						String namePath=rootPath.relativize(file).toString();
						if(!namePath.endsWith(".class")) {
							return FileVisitResult.CONTINUE;
						} 
						namePath=namePath.replaceAll("\\\\", ".");
						namePath=namePath.substring(0, namePath.length()-6);
						//junit类
						if(namePath.startsWith("org.junit.")||namePath.startsWith("org.eclipse.jdt.internal.")) {
							return FileVisitResult.CONTINUE;
						}
						//内部类
						if(namePath.contains("$")) {
							return FileVisitResult.CONTINUE;
						}
						try {
							Class<?> c = Class.forName(namePath, false, loader);
							int mod=c.getModifiers();
							if(!Modifier.isPublic(mod)||Modifier.isInterface(mod)||Modifier.isAbstract(mod)) {
								return FileVisitResult.CONTINUE;
							}  
							if(!clazz.isAssignableFrom(c)) {
								return FileVisitResult.CONTINUE;
							} 
							clazzList.add((Class<T>) c);
						}catch (Exception igr) {
						 
						}
						return FileVisitResult.CONTINUE;
					} 
				});
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		final Iterator<Class<T>> clazzItor = clazzList.iterator();
		Iterator<T> itor = new Iterator<T>() {
			public boolean hasNext() {
				return clazzItor.hasNext();
			} 
			public T next() {
				try {
					return clazzItor.next().newInstance();
				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
		};
		return itor;
	}
	
}
