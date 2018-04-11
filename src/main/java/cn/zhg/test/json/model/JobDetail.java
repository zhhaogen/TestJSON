/**
 * @author zhg
 * 创建于 2016年9月27日 下午3:51:04
 */
package cn.zhg.test.json.model;

import cn.zhg.fastsql.KeyDes;
import cn.zhg.fastsql.KeyType;
import cn.zhg.fastsql.Name;

/**
 * 职位详细信息
 * @author zhg
 *
 */
@Name("JobDetail")
public class JobDetail  
{  
	@KeyDes("DEFAULT NULL COMMENT '关键字信息'")
	public String keywords; 
	@KeyDes("DEFAULT NULL COMMENT '职位链接'")
	public String jhref; 
	@KeyType("varchar(100)")
	@KeyDes("DEFAULT NULL COMMENT '职位ID'")
	public String jobid; 
	@KeyDes("DEFAULT NULL COMMENT '职位名称'")
	public String jobname; 
	@KeyDes("DEFAULT NULL COMMENT '公司名称'")
	public String cname;
	@KeyType("varchar(50)")
	@KeyDes("DEFAULT NULL COMMENT '公司id'")
	public String cid;
	@KeyDes("DEFAULT NULL COMMENT '公司链接'")
	public String chref; 
	@KeyDes("DEFAULT NULL COMMENT '职位描述'")
	public String jdetail; 
	@KeyDes("DEFAULT NULL COMMENT '所属行业'")
	public String Industry;  
	@KeyDes("DEFAULT NULL COMMENT '公司性质'")
	public String cotype;  
	@KeyDes("DEFAULT NULL COMMENT '公司规模'")
	public String companysize; 
	@KeyDes("DEFAULT NULL COMMENT '薪资范围'")
	public String providesalary; 
	@KeyDes("DEFAULT NULL COMMENT '学历要求'")
	public String degreefrom;
	@KeyDes("DEFAULT NULL COMMENT '工作年限'")
	public String workyear;
	@KeyDes("DEFAULT NULL COMMENT '招聘人数'")
	public String jobnum; 
	@KeyDes("DEFAULT NULL COMMENT '工作地址'")
	public String jobadr; 
}
