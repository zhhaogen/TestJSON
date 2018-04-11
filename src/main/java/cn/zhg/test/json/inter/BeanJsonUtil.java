/**
 * 创建于2018-04-10 12:52:25
 * @author zhhaogen
 */
package cn.zhg.test.json.inter;

/**
 * @author zhhaogen
 *
 */
public interface BeanJsonUtil<T> extends JsonUtil
{
	String beanToJson(T bean);
	T toBean(String jos);
	
	@SuppressWarnings("unchecked")
	@Override
	default String toJson(Object obj)
	{
		return this.beanToJson((T) obj);
	}
	@SuppressWarnings("unchecked")
	@Override
	default <A> A toObject(String jos, Class<A> clz)
	{ 
		@SuppressWarnings("unused")
		Class<T> _clz=(Class<T>) clz;
		return  (A) this.toBean(jos);
	}
	
}
