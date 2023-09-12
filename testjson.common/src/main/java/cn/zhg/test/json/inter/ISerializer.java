package cn.zhg.test.json.inter;
/**
 * json系列化
 */
public interface ISerializer {
	/**
	 * 转换成json字符串
	 * @param obj 对象,允许为null
	 */
	String toJson(Object obj);
}
