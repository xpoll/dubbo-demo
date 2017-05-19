package cn.blmdz.common;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * SOA RPC 调用封装对象，判断传输数据正确与否以及错误信息展示
 * 只加msg未加code，因为一般你基本不会为了这个code做额外处理
 * 
 * @author xpoll
 * @mail blmdz521@126.com
 * @address www.blmdz.cn
 */
@ToString
public class Response<T> implements Serializable {
    private static final long serialVersionUID = -4612301430071730437L;
    
    @Setter
    @Getter
    private boolean success;
    @Getter
    private T data;
    @Getter
    private String msg;

    public void setData(T data) {
        this.success = true;
        this.data = data;
    }

    public void setMsg(String msg) {
        this.success = false;
        this.msg = msg;
    }

    public static <T> Response<T> ok(T data) {
        Response<T> resp = new Response<T>();
        resp.setData(data);
        return resp;
    }

    public static <T> Response<T> fail(String error) {
        Response<T> resp = new Response<T>();
        resp.setMsg(error);
        return resp;
    }

    public static <T> Response<T> ok() {
        return ok(null);
    }

}
