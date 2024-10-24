package vip.openpark.snowflake.util;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

/**
 * @author anthony
 * @version 2024-10-24
 * @since 2024-10-24 09:52
 */
public class SnowflakeIdGenerator4TimeBackTest {

	/**
	 * 模拟时钟回拨
	 */
	@Test
	public void timeBackTest() throws InterruptedException {
		SnowflakeIdGenerator4TimeBack generator = new SnowflakeIdGenerator4TimeBack(1, 1);

		// 生成一组 ID
		for (int i = 0; i < 10; i++) {
			long id = generator.nextId();
			System.out.println("Generated ID: " + id);
			Thread.sleep(1);  // 确保每次调用的时间戳不同
		}

		System.out.println("模拟时钟回拨");

		// 进行时间回拨测试
		long previousTime = System.currentTimeMillis();
		// 这里的代码仅示意实际情况，模拟回拨
		MockedStatic<TimeUtil> systemMockedStatic = Mockito.mockStatic(TimeUtil.class);
		systemMockedStatic
			.when(TimeUtil::getCurrentTimeMillis)
			//模拟一秒前的时间
			.thenReturn(previousTime - 1000);

		// 继续生成 ID，将会出现时钟回拨问题
		for (int i = 0; i < 10; i++) {
			long id = generator.nextId(); // 这将抛出错误
			System.out.println("Generated ID after rollback: " + id);
		}
	}
}