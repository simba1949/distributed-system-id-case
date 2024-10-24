package vip.openpark.baidu.config;

import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * 百度 uid-generator 配置类
 *
 * @author anthony
 * @version 2024-10-24
 * @since 2024-10-24 11:25
 */
@Slf4j
@Configuration
public class UidGeneratorConfiguration {

	@Bean
	public DisposableWorkerIdAssigner disposableWorkerIdAssigner() {
		return new DisposableWorkerIdAssigner();
	}

	@Bean
	@Lazy(value = false)
	public DefaultUidGenerator defaultUidGenerator() {
		DefaultUidGenerator uidGenerator = new DefaultUidGenerator();
		uidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner());

		uidGenerator.setTimeBits(29);
		uidGenerator.setWorkerBits(21);
		uidGenerator.setSeqBits(13);
		uidGenerator.setEpochStr("2024-10-24");

		return uidGenerator;
	}

//	@Bean
//	public CachedUidGenerator cachedUidGenerator() {
//		CachedUidGenerator uidGenerator = new CachedUidGenerator();
//		uidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner());
//
//		uidGenerator.setTimeBits(29);
//		uidGenerator.setWorkerBits(21);
//		uidGenerator.setSeqBits(13);
//		uidGenerator.setEpochStr("2024-10-24");
//
//		uidGenerator.setBoostPower(3);
//		uidGenerator.setScheduleInterval(60);
//
//		return uidGenerator;
//	}
}