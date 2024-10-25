package vip.openpark.baidu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

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
//@ImportResource(locations = {"classpath:uid/cached-uid-spring.xml"})
//@ImportResource(locations = {"classpath:uid/default-uid-spring.xml"})
public class UidGeneratorXmlConfiguration {
}