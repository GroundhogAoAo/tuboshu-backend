package com.tubushu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
@MapperScan("com.tuboshu.dao")
public class UserProvider8001_App{
	public static void main(String[] args){
		SpringApplication.run(UserProvider8001_App.class, args);
	}
}
