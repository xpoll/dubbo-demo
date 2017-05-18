package cn.blmdz.dubbo.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.google.common.collect.Lists;

import cn.blmdz.common.BasePage;
import cn.blmdz.common.Response;
import cn.blmdz.dubbo.dao.StudentDao;
import cn.blmdz.dubbo.entity.Student;
import cn.blmdz.dubbo.model.StudentVo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public Response<BasePage<Void, StudentVo>> findBySelect(BasePage<Void, StudentVo> base) {
		
		PageHelper.startPage(base.getNum(), base.getSize(), base.getOrder());
		
		List<StudentVo> list = Lists.newArrayList();
		Page<Student> page = studentDao.page();
		
		for (Student student : page) {
			StudentVo vo = new StudentVo();
			BeanUtils.copyProperties(student, vo);
			list.add(vo);
		}
		
		base.setData(list);
		base.setTotal(page.getTotal());
		
		
		return Response.ok(base);
	}

}
