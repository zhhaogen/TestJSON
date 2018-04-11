/**
 * 创建于2018-04-10 13:20:34
 * @author zhhaogen
 */
package cn.zhg.test.json.jsonutil;

import cn.zhg.test.json.inter.JsonUtil;
import net.minidev.json.JSONValue;

/**
 * @author zhhaogen
 *
 */
public class SmartJsonUtil implements JsonUtil
{

	@Override
	public String toJson(Object obj)
	{
		return JSONValue.toJSONString(obj);
	}

	@Override
	public <T> T toObject(String jos, Class<T> clz)
	{
		return JSONValue.parse(jos, clz);
	}

}
