package cn.zhg.test.json.parser;
/**
 * bean转换器
 */
public abstract class AbsBeanParser<T> {
	public abstract String toJson(T obj) ;
	public abstract T toObject(String json) ;
}
