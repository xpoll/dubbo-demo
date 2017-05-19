package cn.blmdz.dubbo;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.github.pagehelper.PageHelper;

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
@ComponentScan
@SpringBootApplication
public class ProvideApplication {

	/**
	 * 分页插件
	 */
	@Bean
	public PageHelper pageHelper(DataSource dataSource) {
		PageHelper pageHelper = new PageHelper();
		Properties properties = new Properties();
		properties.setProperty("offsetAsPageNum", "true");
		properties.setProperty("rowBoundsWithCount", "true");
		properties.setProperty("reasonable", "true");
		pageHelper.setProperties(properties);
		return pageHelper;
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(ProvideApplication.class, "classpath:/dubbo-provider.xml");
		application.run(args);
	}
}
