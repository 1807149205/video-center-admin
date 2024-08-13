package org.wzl.videocenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "org.wzl.videocenter.mapper")
@SpringBootApplication
public class VideocenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideocenterApplication.class, args);
	}

}
