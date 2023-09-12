package cn.zhg.test.json.util;

import java.time.Duration;

/**
 * 计时工具
 */
public final class DurationUtil {
	private DurationUtil() {}
	private static long startTime;
	private static long splitTime;
	/**
	 * 开始计时
	 */
	public static void begin() {
		startTime=System.currentTimeMillis();
		splitTime=startTime;
	}
	/**
	 * 分段点计时 
	 */
	public static String split() {
		long now = System.currentTimeMillis();
		Duration d = Duration.ofMillis(now-splitTime);
		splitTime=now;
		return d.toString().replace("PT", "").replace("H", "时").replace("M", "分").replace("S", "秒");
	} 
	/**
	 * 当前计时 
	 */
	public static String time() {
		long now = System.currentTimeMillis();
		Duration d = Duration.ofMillis(now-startTime); 
		return d.toString().replace("PT", "").replace("H", "时").replace("M", "分").replace("S", "秒");
	} 
}
