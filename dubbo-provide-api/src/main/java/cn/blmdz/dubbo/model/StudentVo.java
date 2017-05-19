package cn.blmdz.dubbo.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Vo-数据层与调用模块分离，完全不依赖
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private Integer age;
}
