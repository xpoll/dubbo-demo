package cn.blmdz.boot.dubbo.autoconfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.util.SocketUtils;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.ProtocolConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.google.common.base.MoreObjects;
import com.google.common.base.Strings;

import cn.blmdz.boot.dubbo.command.DubboServiceLatchCommandLineRunner;
import cn.blmdz.boot.dubbo.command.DubboServiceListenerBean;
import cn.blmdz.boot.dubbo.properties.DubboProperties;
import lombok.extern.slf4j.Slf4j;

/**
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
@Slf4j
@Order
@Configuration
@EnableConfigurationProperties({ DubboProperties.class })
public class DubboAutoConfiguration {
	
	@Autowired
	private DubboProperties dubboProperties;
	@Value("${spring.application.name:}")
	private String appName;

	@Bean
	public ApplicationConfig applicationConfig() {
		ApplicationConfig config = new ApplicationConfig();
		if (Strings.isNullOrEmpty(dubboProperties.getName()) && Strings.isNullOrEmpty(appName)) {
			throw new IllegalStateException(
					"AppName can\'t be empty, please make sure that \'dubbo.name\' or \'spring.application.name\' have been set");
		} else {
			config.setName((String) MoreObjects.firstNonNull(dubboProperties.getName(), appName));
			config.setLogger("slf4j");
			return config;
		}
	}

	@Bean
	public RegistryConfig registryConfig() {
		RegistryConfig config = new RegistryConfig();
		config.setAddress(dubboProperties.getRegistry());
		config.setProtocol("zookeeper");
		config.setTimeout(dubboProperties.getTimeout());
		config.setVersion(dubboProperties.getVersion());
		return config;
	}

	@Bean
	@ConditionalOnProperty(prefix = "dubbo", name = "mode", havingValue = "provider", matchIfMissing = true)
	public ProtocolConfig protocolConfig() {
		ProtocolConfig config = new ProtocolConfig();
		config.setName("dubbo");
		if (dubboProperties.getHost() != null) {
			config.setHost(dubboProperties.getHost());
		}

		if (dubboProperties.getSerialization() != null) {
			config.setSerialization(dubboProperties.getSerialization());
		}

		if (dubboProperties.getPort().intValue() == -1) {
			int port = SocketUtils.findAvailableTcpPort(30000);
			config.setPort(Integer.valueOf(port));
		} else {
			config.setPort(dubboProperties.getPort());
		}

		config.setThreads(dubboProperties.getThreads());
		config.setHeartbeat(dubboProperties.getHeartBeats());
		return config;
	}

	@Bean
	public ConsumerConfig consumerConfig() {
		ConsumerConfig config = new ConsumerConfig();
		config.setTimeout(Integer.valueOf(10000));
		return config;
	}
	@Bean
	@ConditionalOnProperty(prefix = "dubbo", name = "mode", havingValue = "provider", matchIfMissing = true)
	public DubboServiceLatchCommandLineRunner configureDubboServiceLatchCommandLineRunner() {
		return new DubboServiceLatchCommandLineRunner();
	}

	@Bean
	public DubboServiceListenerBean dubboServiceListenerBean() {
		log.info("Auto start dubbo configuration");
		log.info("port          --> {}", dubboProperties.getPort());
		log.info("registry      --> {}", dubboProperties.getRegistry());
		log.info("threads       --> {}", dubboProperties.getThreads());
		log.info("timeout       --> {}", dubboProperties.getTimeout());
		log.info("heartBeats    --> {}", dubboProperties.getHeartBeats());
		log.info("host          --> {}", dubboProperties.getHost());
		log.info("mode          --> {}", dubboProperties.getMode());
		log.info("serialization --> {}", dubboProperties.getSerialization());
		return new DubboServiceListenerBean(MoreObjects.firstNonNull(dubboProperties.getName(), appName));
	}
}
