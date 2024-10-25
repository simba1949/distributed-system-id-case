package vip.openpark.baidu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 前置条件
 * 1. 基于 jdk8/maven 进行 install 到本地或者 deploy 到 maven 私服。mvn clean install -DskipTests
 * 2. 创建自己的项目并依赖 UidGenerator
 * 3. 创建数据库及 work_node 表：<a href="https://github.com/baidu/uid-generator/blob/master/src/main/scripts/WORKER_NODE.sql">...</a>
 *
 * @author anthony
 * @version 2024-10-24
 * @since 2024-10-24 10:53
 */
@MapperScan("com.baidu.fsg.uid.worker.dao")
@SpringBootApplication
public class UidGeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(UidGeneratorApplication.class, args);
	}
}