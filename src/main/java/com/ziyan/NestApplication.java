package com.ziyan;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.net.InetAddress;
import java.net.UnknownHostException;


@ImportResource("classpath*:/spring-shiro.xml")
@EnableAutoConfiguration
@SpringBootApplication
@EnableWebMvc
public class NestApplication {
	private static final Logger log = LoggerFactory.getLogger(NestApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		Environment env = SpringApplication.run(NestApplication.class, args).getEnvironment();
		log.info(
				"\n----------------------------------------------------------\n\t"
						+ "Application '{}' is running! Access URLs:\n\t" + "Local: \t\thttp://127.0.0.1:{}\n\t"
						+ "External: \thttp://{}:{}\n----------------------------------------------------------",
				env.getProperty("spring.application.name"), env.getProperty("server.port"),
				InetAddress.getLocalHost().getHostAddress(), env.getProperty("server.port"));

		log.info(
				"\n----------------------------------------------------------\n");
	}
}
