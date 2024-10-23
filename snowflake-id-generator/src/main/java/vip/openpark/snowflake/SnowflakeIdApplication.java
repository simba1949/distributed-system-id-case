package vip.openpark.snowflake;

import vip.openpark.snowflake.util.SnowflakeIdGenerator;

import java.util.stream.Stream;

/**
 * @author anthony
 * @version 2024-10-23
 * @since 2024-10-23 17:34
 */
public class SnowflakeIdApplication {
	public static void main(String[] args) {
		SnowflakeIdGenerator snowflakeIdGenerator = new SnowflakeIdGenerator(1, 1);
		Stream.iterate(0, i -> i + 1)
			.limit(1000)
			.forEach(i -> new Thread(() -> {
				Thread thread = Thread.currentThread();
				System.out.println("Thread name is " + thread.getName() + ", id is " + snowflakeIdGenerator.nextId());
			}).start());
	}
}