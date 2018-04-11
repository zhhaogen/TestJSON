/**
 * 创建于2018-04-10 12:41:32
 * @author zhhaogen
 */
package cn.zhg.test.json.jsonutil;

import org.json.*;

import cn.zhg.test.json.inter.BeanJsonUtil;
import cn.zhg.test.json.model.JobSummary;

/**
 * 普通系列化
 * 
 * @author zhhaogen
 *
 */
public class JobSummaryJsonUtil implements BeanJsonUtil<JobSummary>
{

	@Override
	public String beanToJson(JobSummary item)
	{
		JSONObject jos = new JSONObject();
		jos.put("area", item.area);
		jos.put("chref", item.chref);
		jos.put("cid", item.cid);
		jos.put("cname", item.cname);
		jos.put("jhref", item.jhref);
		jos.put("jobid", item.jobid);
		jos.put("jobname", item.jobname);
		jos.put("salary", item.salary);
		jos.put("updateTime", item.updateTime);
		return jos.toString();
	}

	@Override
	public JobSummary toBean(String js)
	{
		JSONObject jos = new JSONObject(js);
		JobSummary item = new JobSummary();
		item.area = jos.optString("area");
		item.chref = jos.optString("chref");
		item.cid = jos.optString("cid");
		item.cname = jos.optString("cname");
		item.jhref = jos.optString("jhref");
		item.jobid = jos.optString("jobid");
		item.jobname = jos.optString("jobname");
		item.salary = jos.optString("salary");
		item.updateTime = jos.optString("updateTime");
		return item;
	}

}
