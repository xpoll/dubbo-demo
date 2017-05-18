package cn.blmdz.provide.service;

import java.util.List;

import cn.blmdz.common.Response;
import cn.blmdz.provide.model.StudentVo;

public interface StudentService {

	/**
	 * 查找所有
	 */
	Response<List<StudentVo>> findAll();
	
}
