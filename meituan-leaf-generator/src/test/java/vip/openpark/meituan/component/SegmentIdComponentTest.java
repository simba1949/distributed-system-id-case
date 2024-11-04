package vip.openpark.meituan.component;

import com.sankuai.inf.leaf.common.Result;
import com.sankuai.inf.leaf.common.Status;
import com.sankuai.inf.leaf.service.SegmentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author anthony
 * @version 2024-11-04
 * @since 2024-11-04 16:36
 */
@Slf4j
@SpringBootTest
public class SegmentIdComponentTest {
	@Autowired
	private SegmentService segmentService;

	@Test
	public void generateId() {
		// 需要提前初始化 key
		Result result = segmentService.getId("leaf-segment-test");
		log.info("result:{}", result);
		if (null != result.getStatus() && Status.SUCCESS == result.getStatus()) {
			long id = result.getId();
			log.info("id:{}", id);
		} else {
			log.error("error:{}", result);
		}
	}
}