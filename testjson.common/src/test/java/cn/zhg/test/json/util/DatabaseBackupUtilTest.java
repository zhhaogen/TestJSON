package cn.zhg.test.json.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class DatabaseBackupUtilTest {

	@Test
	public void testSaveXml() {
		DatabaseBackupUtil.saveXml("jdbc:mysql://127.0.0.1:3306/jobs?useSSL=false", "root", "", "job_jobs", "out.xml");
	} 
}
