/**
 * 创建于2018-04-10 13:24:21
 * @author zhhaogen
 */
package cn.zhg.test.json.jsonutil;

import com.alibaba.fastjson.JSON;

import cn.zhg.test.json.inter.JsonUtil;

/**
 * @author zhhaogen
 *
 */
public class FastJSONJsonUtil implements JsonUtil
{

	@Override
	public String toJson(Object obj)
	{
		return JSON.toJSONString(obj);
	}

	@Override
	public <T> T toObject(String js, Class<T> clz)
	{
		return JSON.parseObject(js, clz);
	}

}
