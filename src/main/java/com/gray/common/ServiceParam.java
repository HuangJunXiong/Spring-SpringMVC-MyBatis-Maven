package com.gray.common;

import java.io.Serializable;

/**
 * Created by lenovo on 2017/3/11.
 */
public class ServiceParam implements Serializable {
    private static final long serialVersionUID = 8038868958129771431L;
    String success; // 成功消息
    String error; // 失败消息
    Object data; // 数据

    public ServiceParam() {
        super();
    }

    // 如果返回String，则为失败消息；其他情况，直接返回数据，没有成功消息，但默认为操作成功！
    public ServiceParam(Object data) {
        super();
        if (data instanceof String) {
            this.error = ((String) data);
        } else {
            this.data = ((String) data);
        }
    }

    public ServiceParam(Object data, String msg, Boolean... isSuccess) {
        super();
        if (isSuccess != null && isSuccess.length > 0 && isSuccess[0] == false) {
            this.error = (msg);
        } else {
            this.success = (msg);
        }
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
