package cn.blmdz.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cn.blmdz.web.exception.GlobalExceptionHandler;

@EnableWebMvc
@SpringBootApplication
@Import(GlobalExceptionHandler.class)
public class DubboWebApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DubboWebApplication.class, "classpath:/dubbo-consumer.xml");
		application.run(args);
	}
}
