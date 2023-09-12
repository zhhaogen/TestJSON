package cn.zhg.test.json.inter;
/**
 * json反系列化
 */
public interface IDeSerializer {
	/**
	 * 将json字符串转换成对象
	 * @param json json字符串,允许为null
	 * @param clazz 对象类型,不能为null
	 */
	<T> T toObject(String json,Class<T> clazz);
}
