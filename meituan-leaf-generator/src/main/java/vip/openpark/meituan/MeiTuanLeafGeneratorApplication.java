package vip.openpark.meituan;

import com.sankuai.inf.leaf.plugin.annotation.EnableLeafServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author anthony
 * @version 2024-10-24
 * @since 2024-10-24 09:37
 */
@EnableLeafServer
@SpringBootApplication
public class MeiTuanLeafGeneratorApplication {
	public static void main(String[] args) {
		SpringApplication.run(MeiTuanLeafGeneratorApplication.class, args);
	}
}