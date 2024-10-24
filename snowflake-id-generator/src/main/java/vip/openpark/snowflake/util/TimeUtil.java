package vip.openpark.snowflake.util;

/**
 * @author anthony
 * @version 2024-10-24
 * @since 2024-10-24 10:21
 */
public class TimeUtil {
	/**
	 * 获取当前时间戳
	 * 为了避免触发无法更改 java.lang.System 类的静态方法的错误
	 *
	 * @return 当前时间戳
	 */
	public static long getCurrentTimeMillis() {
		return System.currentTimeMillis();
	}
}