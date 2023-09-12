package cn.zhg.test.json.convert;

import org.noear.snack.ONode;

import cn.zhg.test.json.inter.IConvert;
import cn.zhg.test.json.util.ReflectUtil;
 
public class SnackJsonConvert implements IConvert
{ 
	public String toJson(Object obj)
	{
		return ONode.stringify(obj);
	} 
	public <T> T toObject(String jos, Class<T> clz)
	{
		return ONode.deserialize(jos, clz);
	}
 
	public String getVersion() {
		return ReflectUtil.getMavenVersion(ONode.class);
	}

}
