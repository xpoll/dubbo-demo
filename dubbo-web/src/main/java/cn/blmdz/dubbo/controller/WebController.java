package cn.blmdz.dubbo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.blmdz.common.BasePage;
import cn.blmdz.common.Response;
import cn.blmdz.dubbo.model.StudentVo;
import cn.blmdz.dubbo.service.StudentService;

/**
 * demo
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
@RestController
public class WebController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value="hello", method=RequestMethod.GET)
	public Response<BasePage<Void, StudentVo>> hello(/*@RequestBody BasePage<Void, StudentVo> base*/) {
		
		BasePage<Void, StudentVo> base = new BasePage<>();
		base.setNum(1);
		base.setSize(3);
		
		return studentService.findBySelect(base);
	}
}
