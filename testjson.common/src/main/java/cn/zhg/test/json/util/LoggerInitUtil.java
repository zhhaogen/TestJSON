package cn.zhg.test.json.util;

import java.io.*;
import java.util.logging.LogManager;
import java.util.logging.Logger;
 
public final class LoggerInitUtil
{
	private static final String fileName = "logging.properties"; 
	private LoggerInitUtil() {}
	/**
	 * 初始化日志管理器
	 */
	static void initLogManager()
	{
		LogManager manager = LogManager.getLogManager();
		try (InputStream is = LoggerInitUtil.class.getResourceAsStream("/" + fileName)) {
			if (is == null) {
				return;
			}
			manager.readConfiguration(is);
		} catch (IOException e) {
		}
	}

	/**
	 * @return
	 */
	public static Logger getLogger()
	{
		initLogManager();
		return Logger.getLogger(LoggerInitUtil.class.getName());
	}

}
