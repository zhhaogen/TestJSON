package cn.zhg.test.json.convert;

import com.alibaba.fastjson.JSON;

import cn.zhg.test.json.inter.*;
 
public class FastJsonConvert implements IConvert
{ 
	public String toJson(Object obj)
	{ 
		return JSON.toJSONString(obj);
	} 
	public <T> T toObject(String js, Class<T> clz)
	{
		return JSON.parseObject(js, clz);
	} 
	public String getVersion() {
		return JSON.VERSION;
	}

}
