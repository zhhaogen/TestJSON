package cn.zhg.test.json.parser;

import org.json.JSONObject;

import cn.zhg.test.json.model.*;

public class UserBeanParser  extends AbsBeanParser<User>{ 
	public String toJson(User obj) {
		JSONObject jsonObj=new JSONObject();
		jsonObj.put("id", obj.id);
		jsonObj.put("name", obj.name);
		return jsonObj.toString();
	} 
	public User toObject(String json) {
		if(json==null) {
			return null;
		}
		JSONObject jsonObj=new JSONObject(json);
		User item=new User();
		item.id=jsonObj.optLong("id",item.id);
		item.name=jsonObj.optString("name", item.name);
		return item;
	}

}
