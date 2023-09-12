package cn.zhg.test.json.convert;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.zhg.test.json.inter.*;
import cn.zhg.test.json.util.ReflectUtil; 
 
public class JackjsonConvert implements IConvert
{ 
	private ObjectMapper jackson;
	public JackjsonConvert() {
		jackson=new ObjectMapper(); 
	}
	public String toJson(Object obj)
	{ 
		try
		{
			return jackson.writeValueAsString(obj);
		} catch (Exception e)
		{ 
			e.printStackTrace();
		}
		return null;
	} 
	public <T> T toObject(String js, Class<T> clz)
	{ 
		try
		{ 
			return jackson.readValue(js, clz);
		} catch ( Exception e)
		{ 
			e.printStackTrace();
		}
		return null; 
	} 
	public String getVersion() {  
		return ReflectUtil.getMavenVersion(ObjectMapper.class);
	}

}
