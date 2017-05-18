package cn.blmdz.dubbo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import cn.blmdz.boot.dubbo.autoconfigure.DubboAutoConfiguration;
import cn.blmdz.provide.service.StudentService;
import cn.blmdz.web.DubboWebApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@AutoConfigureBefore(DubboAutoConfiguration.class)
@SpringApplicationConfiguration(value=DubboWebApplication.class, locations="classpath:dubbo-consumer.xml")
@WebAppConfiguration
public class StudentTest {

	@Autowired
	private StudentService studentService;
	
	
	@Test
	public void findAll(){
		System.out.println(studentService.findAll());
	}
}
