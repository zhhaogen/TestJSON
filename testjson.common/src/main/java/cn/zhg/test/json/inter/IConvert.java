package cn.zhg.test.json.inter;

import cn.zhg.test.json.util.ReflectUtil;

/**
 * json转换器,包括json系列化和反系列化
 */
public interface IConvert extends ISerializer,IDeSerializer{
	/**
	 * 转换器名称 
	 */
	default String getName() { 
		return ReflectUtil.getName(getClass(), "Convert");
	}
	/**
	 * 转换器版本
	 */
	String getVersion();
}
