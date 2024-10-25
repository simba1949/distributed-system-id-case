package vip.openpark.baidu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * 百度 uid-generator 配置类
 *
 * @author anthony
 * @version 2024-10-24
 * @since 2024-10-24 11:25
 */
@Configuration
@ImportResource(locations = {"classpath:uid/cached-uid-spring.xml"})
public class UidGeneratorConfiguration {
}