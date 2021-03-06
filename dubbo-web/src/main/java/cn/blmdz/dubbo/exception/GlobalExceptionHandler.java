package cn.blmdz.dubbo.exception;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.blmdz.common.GlobalException;
import cn.blmdz.common.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * 全局异常封装处理
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
@Slf4j
@ControllerAdvice
@Configuration
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
    public Response<?> exceptionHandler(
    		Exception e) throws Exception {
		if (e instanceof GlobalException) {
			log.debug("GlobalException:{}", e.getMessage());
			
			return Response.fail(e.getMessage());
		}
		log.debug("Exception:{}", e.getMessage());
		return Response.fail("系统异常");
    }
}
