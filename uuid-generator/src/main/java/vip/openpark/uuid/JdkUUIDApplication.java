package vip.openpark.uuid;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author anthony
 * @version 2024-10-23
 * @since 2024-10-23 16:15
 */
public class JdkUUIDApplication {
	public static void main(String[] args) {
		// 【不推荐】UUID v1
		uuidV1();

		// UUID v4
		uuidV4();
	}

	/**
	 * UUID v4
	 */
	public static void uuidV4() {
		// UUID 使用密码学强伪随机数生成器生成
		UUID uuid = UUID.randomUUID();
		System.out.println(uuid);

		// 该 UUID 是根据输入的字节数组（通常是字符串转换成的字节）生成的，保证给定的输入在相同条件下始终会返回相同的 UUID。
		// 该方法使用 SHA-1 散列算法根据输入的字节数组计算一个散列值，并将该散列值转换为 UUID。
		// 使用相同的输入字节数组将始终生成相同的 UUID，因此它们是确定性的。
		String text = "太阳明天依旧照常升起！";
		Set<UUID> collect = Stream.iterate(0, i -> i + 1)
			.limit(1000)
			.map(i -> UUID.nameUUIDFromBytes(text.getBytes()))
			.collect(Collectors.toSet());
		if (collect.size() != 1) {
			throw new RuntimeException("UUID.nameUUIDFromBytes() 测试失败");
		}

		// 将一个标准的 UUID 字符串表示形式转换为相应的 UUID 对象，使得程序能够轻松处理和处理该 UUID
		UUID uuidFromOldUUIDStr = UUID.fromString("acb38417-4803-45a6-bc6d-59cb96289843");
		// 获取 UUID 的版本号
		int version = uuidFromOldUUIDStr.version();
		System.out.println("version = " + version);
	}

	/**
	 * UUID v1
	 */
	public static void uuidV1() {
		// 7d8645e4-911f-11ef-ad4f-bd4fabec5d41 是 UUID V1 产生的唯一标识符
		UUID uuidV1 = UUID.fromString("7d8645e4-911f-11ef-ad4f-bd4fabec5d41");
		// UUID v1（基于时间和节点的 UUID） ，如果不是 UUID v1 则会抛出 java.lang.UnsupportedOperationException
		// long timestamp = uuidFromOldUUIDStr.timestamp();
		System.out.println("V1 timestamp = " + uuidV1.timestamp());
	}
}