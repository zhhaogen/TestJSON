/**
 * 创建于2018-04-10 12:28:17
 * @author zhhaogen
 */
package cn.zhg.test.json.inter;

/**
 * json转换工具
 * 
 * @author zhhaogen
 *
 */
public interface JsonUtil
{
	/**
	 * 转换为json字符串
	 * 
	 * @param obj
	 * @return
	 */
	String toJson(Object obj);

	/**
	 * 转换为Object
	 * 
	 * @param js
	 * @param clz
	 * @return
	 */
	<T> T toObject(String js, Class<T> clz); 
 
}
