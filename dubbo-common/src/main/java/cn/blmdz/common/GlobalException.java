package cn.blmdz.common;

/**
 * 全局RuntimeException异常
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
public class GlobalException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    public GlobalException() {
        super();
    }
    public GlobalException(String message) {
        super(message);
    }
    public GlobalException(String message, Throwable throwable) {
        super(message, throwable);
    }
    public GlobalException(Throwable throwable) {
        super(throwable);
    }
    public GlobalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
