package cn.blmdz.common;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Data;

/**
 * 分页总类
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
@Data
public class BasePage<S, T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/** 每页多少个 */
	private int size;
	
	/** 第几页 */
	private int num;
	
	/** total */
	private long total;
	
	/** 返回数据 */
	private List<T> data;
	
	/** 搜索 */
	@JsonProperty(access = Access.WRITE_ONLY)
	private S mode;
	
	/** 排序 */
	@JsonProperty(access = Access.WRITE_ONLY)
	private String order;
}
