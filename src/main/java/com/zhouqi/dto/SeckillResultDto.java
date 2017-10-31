package com.zhouqi.dto;
//将所有的ajax请求返回类型，全部封装成json数据
public class SeckillResultDto<T> {
    private Boolean success;
    private T data;
    private String error;

    public SeckillResultDto(Boolean success, T data) {
        this.success = success;
        this.data = data;
    }

    public SeckillResultDto(Boolean success, String error) {
        this.success = success;
        this.error = error;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
