package vip.openpark.baidu.config;

import com.baidu.fsg.uid.impl.CachedUidGenerator;
import com.baidu.fsg.uid.impl.DefaultUidGenerator;
import com.baidu.fsg.uid.worker.DisposableWorkerIdAssigner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 百度 uid-generator 配置类
 * 第一种方式：使用 @Bean，如 UidGeneratorBeanConfiguration 具体配置信息
 * 第二种方式：在 XML 配置，使用 @ImportResource 导入配置
 * 1. @ImportResource(locations = {"classpath:uid/cached-uid-spring.xml"})
 * 2. @ImportResource(locations = {"classpath:uid/default-uid-spring.xml"})
 *
 * @author anthony
 * @version 2024-10-24
 * @since 2024-10-24 11:25
 */
@Configuration
public class UidGeneratorBeanConfiguration {

	@Bean
	public DisposableWorkerIdAssigner disposableWorkerIdAssigner() {
		return new DisposableWorkerIdAssigner();
	}

	/**
	 * 配置信息详见：
	 * <a href="https://github.com/baidu/uid-generator/blob/master/README.zh_cn.md#cacheduidgenerator%E9%85%8D%E7%BD%AE">...</a>
	 *
	 * @return CachedUidGenerator
	 */
	@Bean
	public CachedUidGenerator cachedUidGenerator() {
		CachedUidGenerator uidGenerator = new CachedUidGenerator();
		uidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner());

		uidGenerator.setBoostPower(3);
		uidGenerator.setScheduleInterval(60L);

		return uidGenerator;
	}

	/**
	 * 配置信息详见：
	 * <a href="https://github.com/baidu/uid-generator/blob/master/README.zh_cn.md#defaultuidgenerator%E9%85%8D%E7%BD%AE">...</a>
	 *
	 * @return DefaultUidGenerator
	 */
	@Bean
	public DefaultUidGenerator defaultUidGenerator() {
		DefaultUidGenerator uidGenerator = new DefaultUidGenerator();
		uidGenerator.setWorkerIdAssigner(disposableWorkerIdAssigner());

		uidGenerator.setTimeBits(29);
		uidGenerator.setWorkerBits(21);
		uidGenerator.setSeqBits(13);
		uidGenerator.setEpochStr("2024-10-24");

		return uidGenerator;
	}
}