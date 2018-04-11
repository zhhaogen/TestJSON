/**
 * 创建于2018-04-10 12:32:13
 * @author zhhaogen
 */
package cn.zhg.test.json;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import com.db4o.Db4oEmbedded;
import com.db4o.EmbeddedObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.reflect.ReflectClass;

import cn.zhg.fastsql.FastMySql;
import cn.zhg.test.json.inter.JsonUtil;
import cn.zhg.test.json.jsonutil.*;
import cn.zhg.test.json.model.*;
import xiaogen.util.Logger;

/**
 * @author zhhaogen
 *
 */
@SuppressWarnings({ "rawtypes", "unused" })
public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Logger.st();
		List datas = initDatas3();
		Logger.t("初始化数据");
		Logger.d("数据大小:" + datas.size());
//		testJsonUtil(new JobSummaryFastJsonUtil(), datas);
//		 testJsonUtil(new JobSummaryJsonUtil(), datas);
//		 testJsonUtil(new SmartJsonUtil(), datas);
//		 testJsonUtil(new FastJSONJsonUtil(), datas);
//		 testJsonUtil(new JackJSONJsonUtil(), datas);
		 testJsonUtil(new GsonJsonUtil(), datas);
	}

	/**
	 * @param datas
	 */
	private static void saveDatas(List datas)
	{
		try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("datas.obj")))
		{
			os.writeObject(datas);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static List initDatas()
	{
		try (ObjectInputStream os = new ObjectInputStream(new FileInputStream("datas.obj")))
		{
			return (List) os.readObject();
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	private static List initDatas3()
	{
		// 2951.047823ms
		ArrayList<JobSummary> datas = new ArrayList<>();
		for (int i = 0; i < 100 * 10000; i++)
		{
			JobSummary item = new JobSummary();
			item.jobid = i + "";
			item.jobname = UUID.randomUUID().toString();
			datas.add(item);
		}
		return datas;
	}

	private static List initDatas2()
	{
		// EmbeddedObjectContainer db =
		// Db4oEmbedded.openFile("src/main/resources/bus.dll");
		// ReflectClass[] cls = db.ext().knownClasses();
		// Logger.d(cls);
		// List<JobSummary> datas =new ArrayList<>( db.query(JobSummary.class));
		// db.close();
		// return datas;
		return new ArrayList<>();
	}

	private static List initDatas1()
	{
		String url = "jdbc:mysql://127.0.0.1:3306/taskdb?useUnicode=true&characterEncoding=UTF-8&useSSL=false&autoReconnect=true";
		String user = "root";
		String password = "";

		List<JobSummary> datas = FastMySql.getFactory(url, user, password).read(JobSummary.class);

		return datas;
	}

	public static void testJsonUtil(JsonUtil util, List datas)
	{
		Logger.st();
		for (Object data : datas)
		{
			String js = util.toJson(data);
			// System.out.println(js);
		}
		long dif = Logger.t("[" + util.getClass().getSimpleName() + "]系列化数据");
		try
		{
			Files.write(new File("result.txt").toPath(),Arrays.asList( util.getClass().getSimpleName() + "\t" + datas.size() + "\t" + dif),
					StandardOpenOption.APPEND,StandardOpenOption.CREATE);
		} catch ( Exception e)
		{  
		}
	}
}
