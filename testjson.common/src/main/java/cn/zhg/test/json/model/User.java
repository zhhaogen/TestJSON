package cn.zhg.test.json.model;

import java.util.Objects;

/**
 * 一个用户简单模型
 */
public class User {
	public long id;
	/**
	 * 用户名
	 */
	public String name;
  
	public int hashCode() {
		return Objects.hash(id, name);
	}
 
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		return id == other.id && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "{id:" + id + ", name:" + name + "}";
	}

}
