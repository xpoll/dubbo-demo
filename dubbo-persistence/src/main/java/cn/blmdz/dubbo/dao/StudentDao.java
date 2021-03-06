package cn.blmdz.dubbo.dao;

import java.util.List;

import com.github.pagehelper.Page;

import cn.blmdz.dubbo.entity.Student;

/**
 * mapper dao层
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
public interface StudentDao {

	int insert(Student student);

	int delete(Long id);

	Student findById(Long id);

	List<Student> list();

	Page<Student> page();

	Page<Student> pageBySelect();
}