package vip.openpark.baidu.compoent;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author anthony
 * @version 2024-10-24
 * @since 2024-10-24 13:46
 */
@Slf4j
@SpringBootTest
public class UidGeneratorComponentTest {
	@Resource
	private UidGeneratorComponent uidGeneratorComponent;

	@Test
	public void nextIdTest(){
		log.info("nextId:{}",uidGeneratorComponent.nextId());
	}
}
