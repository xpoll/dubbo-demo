package cn.blmdz.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.blmdz.common.Response;
import cn.blmdz.provide.model.StudentVo;
import cn.blmdz.provide.service.StudentService;

@RestController
public class WebController {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value="hello", method=RequestMethod.GET)
	public Response<List<StudentVo>> hello() {
		
		return studentService.findAll();
	}
}
