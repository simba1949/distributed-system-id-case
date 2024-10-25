package vip.openpark.baidu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
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