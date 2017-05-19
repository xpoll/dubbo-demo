package cn.blmdz.dubbo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import cn.blmdz.dubbo.exception.GlobalExceptionHandler;

/**
 * 模块启动类<br>
 * <code>@Bean</code>可以新建配置文件去做，用<code>@Configuration</code><br>
 * IDE中运行或启动直接运行此类<br>
 * spring-boot 中不要乱写main方法，应在test中写<br>
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
@EnableWebMvc
@SpringBootApplication
@Import(GlobalExceptionHandler.class)
public class DubboApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DubboApplication.class,
				"classpath:/dubbo-consumer.xml");
		application.run(args);
	}
}
