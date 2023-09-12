package cn.zhg.test.json.convert;

import com.google.gson.Gson;

import cn.zhg.test.json.inter.*;
import cn.zhg.test.json.util.ReflectUtil;

public class GsonConvert implements IConvert {
	private Gson gson; 
	public GsonConvert() {
		gson = new Gson();
	} 
	public String toJson(Object obj) {
		return gson.toJson(obj);
	} 
	public <T> T toObject(String js, Class<T> clz) {
		return gson.fromJson(js, clz);
	} 
	public String getVersion() {
		return ReflectUtil.getMavenVersion(Gson.class);
	}

}
