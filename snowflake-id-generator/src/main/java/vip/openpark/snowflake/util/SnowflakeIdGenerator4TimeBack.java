package vip.openpark.snowflake.util;

/**
 * 原始 Snowflake ID 生成器
 * 该类用于复现时钟回拨
 *
 * @author anthony
 * @version 2024-10-23
 * @since 2024-10-23 17:37
 */
public class SnowflakeIdGenerator4TimeBack {
	private final long epoch = 1729612800000L; // 自定义纪元
	private final long datacenterIdBits = 5L; // 数据中心ID所占的位数
	private final long workerIdBits = 5L; // 工作机器ID所占的位数
	private final long sequenceBits = 12L; // 序列号所占的位数

	private final long workerIdShift = sequenceBits; // 工作机器ID向左移多少位
	private final long datacenterIdShift = sequenceBits + workerIdBits; // 数据中心ID向左移多少位
	private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits; // 时间戳向左移多少位

	private final long sequenceMask = -1L ^ (-1L << (int) sequenceBits); // 生成序列的掩码，这里为4095
	private final long datacenterId; // 数据中心ID
	private final long workerId; // 工作机器ID
	private long sequence = 0L; // 序列号
	private long lastTimestamp = -1L; // 上一次生成ID的时间戳

	public SnowflakeIdGenerator4TimeBack(long workerId, long datacenterId) {
		if (workerId > (-1L ^ (-1L << (int) workerIdBits))) {
			throw new IllegalArgumentException("workerId can't be greater than %d or less than 0");
		}
		if (datacenterId > (-1L ^ (-1L << (int) datacenterIdBits))) {
			throw new IllegalArgumentException("datacenterId can't be greater than %d or less than 0");
		}
		this.workerId = workerId;
		this.datacenterId = datacenterId;
	}

	/**
	 * 生成下一个ID
	 *
	 * @return ID
	 */
	public synchronized long nextId() {
		long timestamp = currentTimeMillis();
		if (timestamp < lastTimestamp) {
			throw new RuntimeException(String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}

		// 同一毫秒内，序列号累加
		if (lastTimestamp == timestamp) {
			sequence = (sequence + 1) & sequenceMask;
			// 如果序列号溢出，则等待下一个毫秒
			if (sequence == 0) {
				timestamp = waitNextMillis(lastTimestamp);
			}
		} else {
			// 当前毫秒内序列号重置
			sequence = 0L;
		}

		// 更新上次时间戳
		lastTimestamp = timestamp;

		// 组装 ID
		return ((timestamp - epoch) << (int) timestampLeftShift) |
			(datacenterId << (int) datacenterIdShift) |
			(workerId << (int) workerIdShift) |
			sequence;
	}

	/**
	 * 等待下一个毫秒
	 *
	 * @param lastTimestamp 上一次生成ID的时间戳
	 * @return 下一个毫秒的时间戳
	 */
	protected long waitNextMillis(long lastTimestamp) {
		long timestamp = currentTimeMillis();
		while (timestamp <= lastTimestamp) {
			// 等待下一个毫秒
			timestamp = currentTimeMillis();
		}
		return timestamp;
	}

	/**
	 * 获取当前时间戳
	 * 结合 mockito 框架，可以复现时钟回拨
	 *
	 * @return 当前时间戳
	 */
	protected long currentTimeMillis() {
		// return System.currentTimeMillis();
		return TimeUtil.getCurrentTimeMillis();
	}
}