package cn.zhg.test.json.util;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.zhg.test.json.inter.IConvert;

public class ReflectUtilTest {

	@Test
	public void testLoadService() {
		IConvert convert = ReflectUtil.loadService(IConvert.class);
		if(convert==null) {
			return;
		}
		System.out.println(convert.getName()+" "+convert.getVersion());
	}

	@Test
	public void testLoadServices() {
		ReflectUtil.loadServices(IConvert.class);
	}

}
