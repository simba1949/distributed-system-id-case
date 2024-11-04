package vip.openpark.meituan.component;

import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.Status;
import com.sankuai.inf.leaf.service.SnowflakeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author anthony
 * @version 2024-11-04
 * @since 2024-11-04 16:12
 */
@Slf4j
@SpringBootTest
public class SnowflakeIdComponentTest {
	@Autowired
	private SnowflakeService snowflakeService;

	@Test
	public void generateId() {
		Result result = snowflakeService.getId("snowflake-id-test");
		log.info("result:{}", result);
		if (null != result.getStatus() && Status.SUCCESS == result.getStatus()) {
			long id = result.getId();
			log.info("id:{}", id);
		} else {
			log.error("error:{}", result);
		}
	}
}