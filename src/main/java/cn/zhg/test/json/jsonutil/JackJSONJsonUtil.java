/**
 * 创建于2018-04-10 13:34:08
 * @author zhhaogen
 */
package cn.zhg.test.json.jsonutil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import cn.zhg.test.json.inter.JsonUtil;

/**
 * @author zhhaogen
 *
 */
public class JackJSONJsonUtil implements JsonUtil
{

	@Override
	public String toJson(Object obj)
	{
		ObjectMapper map=new ObjectMapper(); 
		try
		{
			return map.writeValueAsString(obj);
		} catch (JsonProcessingException e)
		{ 
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public <T> T toObject(String js, Class<T> clz)
	{
		ObjectMapper map=new ObjectMapper(); 
		try
		{
			
			return map.readValue(js, clz);
		} catch ( Exception e)
		{ 
			e.printStackTrace();
		}
		return null; 
	}

}
