package com.tuyano.springboot;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
@Configuration
public class MyBootAppConfig {

	@Bean
	MyDataBean myDataBean() {
		return new MyDataBean();
	}
}
