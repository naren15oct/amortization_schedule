package com.amortschedule.amortization.schedule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.amortschedule.amortization.schedule.config.SwaggerConfig;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan("com.amortschedule.amortization.schedule")
@ComponentScan(basePackageClasses = {Application.class, SwaggerConfig.class})
//@EnableSwagger2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
