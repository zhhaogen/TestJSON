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
public class JobSummaryFastJsonUtil implements BeanJsonUtil<JobSummary>
{
	private StringBuilder buffer;

	public	JobSummaryFastJsonUtil()
	{
		  buffer = new StringBuilder(1024*1024);
	}
	/**
	 * @param sb
	 * @param key
	 * @param value
	 * @return 
	 */
	private StringBuilder append(StringBuilder sb, String key, String value)
	{
		sb.append("'").append(key).append("':\"").append(value).append("\"");
		return sb;
	}

	/***
	 * 采用字符串快速拼接
	 */
	@Override
	public String beanToJson(JobSummary item)
	{
		buffer.setLength(0);
		buffer.append("{"); 
		append(buffer,"area", item.area).append(",");
		append(buffer,"chref", item.chref).append(",");
		append(buffer,"cid", item.cid).append(",");
		append(buffer,"cname", item.cname).append(",");
		append(buffer,"jhref", item.jhref).append(",");
		append(buffer,"jobid", item.jobid).append(",");
		append(buffer,"jobname", item.jobname).append(",");
		append(buffer,"salary", item.salary).append(",");
		append(buffer,"updateTime", item.updateTime); 
		buffer.append("}");
		return buffer.toString();
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
