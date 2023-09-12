package cn.zhg.test.json.parser;

import cn.zhg.test.json.model.*;

public class JobBeanParser  extends AbsBeanParser<Job>{ 
	public String toJson(Job obj) {
		StringBuilder jsonObj=new StringBuilder();
		jsonObj.append("{");
		jsonObj.append("'").append("id").append("':").append(obj.id);
		jsonObj.append(",'").append("create_time").append("':").append( obj.create_time).append("\"");
		jsonObj.append(",'").append("jobid").append("':").append( obj.jobid).append("\"");
		jsonObj.append(",'").append("jobname").append("':\"").append( obj.jobname).append("\"");
		jsonObj.append(",'").append("cid").append("':\"").append( obj.cid).append("\"");
		jsonObj.append(",'").append("cname").append("':\"").append( obj.cname).append("\"");
		jsonObj.append(",'").append("ads").append("':\"").append( obj.ads).append("\"");
		jsonObj.append(",'").append("des").append("':\"").append(obj.des).append("\"");
		jsonObj.append("}");
		return jsonObj.toString();
	} 
	public Job toObject(String json) { 
		return null;
	}

}
