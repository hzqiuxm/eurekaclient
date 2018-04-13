package com.springcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@EnableEurekaClient
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaclientApplication {

	private static Logger logger = LoggerFactory.getLogger(EurekaclientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaclientApplication.class, args);
	}

	@Value("${server.port}")
	String port;

	@RequestMapping("/hi")
	public String home(@RequestParam String name) throws InterruptedException {

		//测试超时效果，加入一个睡眠时间
		int sleepTIme = new Random().nextInt(4000);
		logger.info("sleepTime = " + sleepTIme);

		Thread.sleep(sleepTIme);

		return "hi " + name +", i am from port" + port;
	}
}
