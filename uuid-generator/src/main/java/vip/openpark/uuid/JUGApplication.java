package vip.openpark.uuid;

import com.fasterxml.uuid.Generators;

import java.util.UUID;

/**
 * java-uuid-generator 库创建 UUID
 * <a href="https://github.com/cowtowncoder/java-uuid-generator">java-uuid-generator github</a>
 *
 * @author anthony
 * @version 2024-10-23
 * @since 2024-10-23 17:11
 */
public class JUGApplication {
	/**
	 * <a href="https://github.com/cowtowncoder/java-uuid-generator?tab=readme-ov-file#generating-uuids">详见官方指南</a>
	 *
	 * @param args args
	 */
	public static void main(String[] args) {
		UUID uuid1 = Generators.timeBasedGenerator().generate(); // Version 1
		System.out.println("V1 uuid = " + uuid1);

		UUID uuid4 = Generators.randomBasedGenerator().generate(); // Version 4
		System.out.println("V4 uuid = " + uuid4);

		UUID uuid5 = Generators.nameBasedGenerator().generate("string to hash"); // Version 5
		System.out.println("V5 uuid = " + uuid5);

		// With JUG 4.1+: support for https://github.com/uuid6/uuid6-ietf-draft versions 6 and 7:
		UUID uuidV6_4 = Generators.timeBasedReorderedGenerator().generate(); // Version 6
		System.out.println("V6 uuid = " + uuidV6_4);
		UUID uuidV7_4 = Generators.timeBasedEpochGenerator().generate(); // Version 7
		System.out.println("V7 uuid = " + uuidV7_4);

		// With JUG 5.0 added variation:
		UUID uuidV7_5 = Generators.timeBasedEpochRandomGenerator().generate(); // Version 7 with per-call random values
		System.out.println("V7 uuid = " + uuidV7_5);
	}
}