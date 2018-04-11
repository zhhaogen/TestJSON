/**
 * @author zhg
 * 创建于 2016年9月27日 下午3:41:47
 */
package cn.zhg.test.json.model;

import cn.zhg.fastsql.KeyDes;
import cn.zhg.fastsql.KeyType;
import cn.zhg.fastsql.Name;

/**
 * @author zhg
 *
 */
@SuppressWarnings("serial")
@Name("JobSummary")
public class JobSummary  implements java.io.Serializable
{
	@KeyDes("DEFAULT NULL COMMENT '职位链接'")
	public String jhref; 
	@KeyType("varchar(100)")
	@KeyDes("DEFAULT NULL COMMENT '职位ID'")
	public String jobid; 
	@KeyDes("DEFAULT NULL COMMENT '职位名称'")
	public String jobname; 
	@KeyType("varchar(50)")
	@KeyDes("DEFAULT NULL COMMENT '公司id'")
	public String cid;
	@KeyDes("DEFAULT NULL COMMENT '公司名称'")
	public String cname;
	@KeyDes("DEFAULT NULL COMMENT '公司链接'")
	public String chref; 
	@KeyType("varchar(100)")
	@KeyDes("DEFAULT NULL COMMENT '区域'")
	public String area;
	@KeyType("varchar(100)")
	@KeyDes("DEFAULT NULL COMMENT '月薪'")
	public String salary;
	@KeyType("varchar(100)")
	@KeyDes("DEFAULT NULL COMMENT '发布时间'")
	public String updateTime;
}
