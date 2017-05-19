package cn.blmdz.boot.dubbo.command;

import java.util.concurrent.CountDownLatch;
import org.springframework.boot.CommandLineRunner;

/**
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
public class DubboServiceLatchCommandLineRunner implements CommandLineRunner {
	public void run(String... args) throws Exception {
		CountDownLatch countDownLatch = new CountDownLatch(1);
		countDownLatch.await();
	}
}
