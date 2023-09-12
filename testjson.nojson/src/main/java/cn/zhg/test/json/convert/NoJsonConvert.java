package cn.zhg.test.json.convert;

import java.lang.reflect.ParameterizedType;
import java.util.*;

import cn.zhg.test.json.inter.IConvert;
import cn.zhg.test.json.parser.*;
import cn.zhg.test.json.util.ReflectUtil;
/**
 * 手动拼接,无任何json依赖
 */
@SuppressWarnings({"rawtypes","unchecked"})
public class NoJsonConvert implements IConvert { 
	private Map<Class<?>,AbsBeanParser> beanParsers ;
	public NoJsonConvert() {
		 beanParsers=new HashMap<>();
		 Iterator<AbsBeanParser> itor = ReflectUtil.loadServices(AbsBeanParser.class);
		 if(itor==null) {
			 return;
		 }
		 while(itor.hasNext()) {
			AbsBeanParser parser = itor.next();
			ParameterizedType pType = (ParameterizedType) parser.getClass().getGenericSuperclass();
			 Class<?> beanType=(Class<?>) pType.getActualTypeArguments()[0];
			beanParsers.put(beanType,parser);
		 } 
	} 
	public String toJson(Object obj) {
		if(obj==null) {
			return null;
		}  
		AbsBeanParser parser = beanParsers.get(obj.getClass());
		if(parser==null) {
			throw new RuntimeException("不支持["+obj.getClass().getName()+"]的转换");
//			return null;
		}
		return parser.toJson(obj);
	} 
	public <T> T toObject(String json, Class<T> clazz) {
		AbsBeanParser parser = beanParsers.get(clazz);
		if(parser==null) {
			throw new RuntimeException("不支持["+clazz.getName()+"]的转换");
//			return null;
		}
		return (T) parser.toObject(json);
	} 
	public String getVersion() {
		return "1";
	}

}
