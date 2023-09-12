package cn.zhg.test.json.convert;

import cn.zhg.test.json.inter.IConvert;
import cn.zhg.test.json.util.ReflectUtil;
import net.minidev.json.JSONValue;
 
public class SmartJsonConvert implements IConvert
{ 
	public String toJson(Object obj)
	{
		return JSONValue.toJSONString(obj);
	} 
	public <T> T toObject(String jos, Class<T> clz)
	{
		return JSONValue.parse(jos, clz);
	}
 
	public String getVersion() {
		return ReflectUtil.getMavenVersion(JSONValue.class);
	}

}
