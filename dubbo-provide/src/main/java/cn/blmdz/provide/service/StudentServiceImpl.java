package cn.blmdz.provide.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;

import cn.blmdz.common.Response;
import cn.blmdz.dao.StudentDao;
import cn.blmdz.entity.Student;
import cn.blmdz.provide.model.StudentVo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;

	@Override
	public Response<List<StudentVo>> findAll() {
		
		PageHelper.startPage(1, 2);
		Page<Student> page = studentDao.page();
		for (Student student : page) {
			System.out.println(student);
		}
		
//		BeanUtils.copyProperties(source, target);
		
		
		List<StudentVo> list = Lists.newArrayList();
		Date date = new Date();
		list.add(new StudentVo(1L, "小明", 10, date));
		list.add(new StudentVo(2L, "小李", 13, date));
		list.add(new StudentVo(3L, "小张", 12, date));
		list.add(new StudentVo(4L, "小杨", 15, date));
		list.add(new StudentVo(5L, "小程", 11, date));
		return Response.ok(list);
	}

}
