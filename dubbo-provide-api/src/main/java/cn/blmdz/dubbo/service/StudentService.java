package cn.blmdz.dubbo.service;

import cn.blmdz.common.BasePage;
import cn.blmdz.common.Response;
import cn.blmdz.dubbo.model.StudentVo;

/**
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
public interface StudentService {

	/**
	 * 查找所有
	 */
	Response<BasePage<Void, StudentVo>> findBySelect(BasePage<Void, StudentVo> base);
	
}
