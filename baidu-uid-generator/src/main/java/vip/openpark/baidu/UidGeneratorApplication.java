package vip.openpark.baidu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Repository;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @author anthony
 * @version 2024-10-24
 * @since 2024-10-24 10:53
 */
@MapperScan(basePackages = {"com.baidu.fsg.uid.worker.dao"}, annotationClass = Repository.class)
@SpringBootApplication
public class UidGeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(UidGeneratorApplication.class, args);
	}
}