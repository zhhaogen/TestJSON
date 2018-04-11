/**
 * 创建于2018-04-10 17:22:51
 * @author zhhaogen
 */
package cn.zhg.test.json.jsonutil;

import com.google.gson.Gson;

import cn.zhg.test.json.inter.JsonUtil;

/**
 * @author zhhaogen
 *
 */
public class GsonJsonUtil implements JsonUtil
{
	Gson gson;

	public GsonJsonUtil()
	{
		gson=new Gson();
	}

	@Override
	public String toJson(Object obj)
	{
		return gson.toJson(obj);
	}

	@Override
	public <T> T toObject(String js, Class<T> clz)
	{
		return gson.fromJson(js, clz);
	}

}
