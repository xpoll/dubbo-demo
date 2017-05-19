package cn.blmdz.dubbo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 数据库entity
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
@Data
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Integer age;
	private Date time;
}
