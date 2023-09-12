package cn.zhg.test.json.parser;

import org.json.JSONObject;

import cn.zhg.test.json.model.*;

public class JobBeanParser  extends AbsBeanParser<Job>{ 
	public String toJson(Job obj) {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("id", obj.id);
		jsonObj.put("create_time", obj.create_time);
		jsonObj.put("jobid", obj.jobid);
		jsonObj.put("jobname", obj.jobname);
		jsonObj.put("cid", obj.cid);
		jsonObj.put("cname", obj.cname);
		jsonObj.put("ads", obj.ads);
		jsonObj.put("des", obj.des);
		return jsonObj.toString();
	} 
	public Job toObject(String json) {
		if(json==null) {
			return null;
		}
		JSONObject jsonObj=new JSONObject(json);
		Job item=new Job();
		item.id=jsonObj.optLong("id",item.id);
		item.create_time=jsonObj.optLong("id",item.create_time); 
		item.jobid=jsonObj.optString("jobid", item.jobid);
		item.jobname=jsonObj.optString("jobname", item.jobname);
		item.cid=jsonObj.optString("cid", item.cid);
		item.cname=jsonObj.optString("cname", item.cname);
		item.ads=jsonObj.optString("ads", item.ads);
		item.des=jsonObj.optString("des", item.des); 
		return item;
	}

}
