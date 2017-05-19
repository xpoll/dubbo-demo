package cn.blmdz.dubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.blmdz.boot.dubbo.autoconfigure.DubboAutoConfiguration;
import cn.blmdz.common.BasePage;
import cn.blmdz.dubbo.model.StudentVo;
import cn.blmdz.dubbo.service.StudentService;

/**
 * 测试 demo
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureBefore(DubboAutoConfiguration.class)
@SpringApplicationConfiguration(value=DubboApplication.class, locations="classpath:dubbo-consumer.xml")
@WebAppConfiguration
public class StudentTest {

	@Autowired
	private StudentService studentService;
	
	
	@Test
	public void findAll(){

		BasePage<Void, StudentVo> base = new BasePage<>();
		base.setNum(1); // 页码
		base.setSize(5);// 每页个数
		
		
		System.out.println(studentService.findBySelect(base));
	}
}
