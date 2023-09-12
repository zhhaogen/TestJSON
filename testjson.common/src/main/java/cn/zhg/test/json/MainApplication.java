package cn.zhg.test.json;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import cn.zhg.test.json.inter.IConvert;
import cn.zhg.test.json.model.*;
import cn.zhg.test.json.util.*;

public class MainApplication {
	private final static Logger log =LoggerInitUtil.getLogger(); 
	public static void main(String[] args) {
		testJdbcJson();
	}

	/**
	 * 将数据库导出为json
	 */
	static void testJdbcJson() {
		log.log(Level.INFO,"==将数据库导出为json==");
		IConvert convert = ReflectUtil.loadService(IConvert.class);
		if (convert == null) {
			log.log(Level.SEVERE,"没有可用的转换器");
			return;
		}
		log.log(Level.INFO,"转换器 :" + convert.getName() + " " + convert.getVersion());
		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/jobs?useSSL=false";
		DurationUtil.begin();
		try (Connection con = DriverManager.getConnection(jdbcUrl, "root", "");) {
			ResultSet res = con.createStatement().executeQuery("select * from job_jobs");
			log.log(Level.INFO,"连接查询耗时 :"+DurationUtil.split()); 
			int i = 0;
			List<Job> list = new LinkedList<>();
			while (res.next()) {
				i++;
				Job item = new Job();
				item.id = res.getLong("id");
				item.create_time = res.getLong("create_time");
				item.jobid = res.getString("jobid");
				item.jobname = res.getString("jobname");
				item.cid = res.getString("cid");
				item.cname = res.getString("cname");
				item.ads = res.getString("ads");
				item.des = res.getString("des");
				list.add(item);
			}
			log.log(Level.INFO,"读取数据 :" + i);
			log.log(Level.INFO,"读取数据耗时 :"+DurationUtil.split());  
			for (Job item : list) {
				 convert.toJson(item);
			}
			log.log(Level.INFO,"系列化耗时 :"+DurationUtil.split()); 
		} catch (Exception e) {
			log.log(Level.SEVERE,"",e);
		}finally {
			log.log(Level.INFO,"全部耗时 :"+DurationUtil.time()); 
		}
	}

	/**
	 * 简单校验json正确性
	 */
	static void testValid() {
		System.out.println("==简单校验json正确性==");
		User user = new User();
		user.id = 2;
		user.name = "小黑";
		IConvert convert = ReflectUtil.loadService(IConvert.class);
		if (convert == null) {
			System.out.println("没有可用的转换器");
			return;
		}
		System.out.println("转换器 :" + convert.getName() + " " + convert.getVersion());
		String json = convert.toJson(user);
		System.out.println("json字符串:");
		System.out.println(json);
		User newItem = convert.toObject(json, User.class);
		System.out.println("是否完全一致:" + user.equals(newItem));
	}
}
