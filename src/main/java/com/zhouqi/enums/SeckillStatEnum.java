package com.zhouqi.enums;

public enum SeckillStatEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT(-1,"重复秒杀"),
    INNER_ERROR(-2,"系统错误"),
    DATA_REWRITE(-3,"数据篡改");

    private Integer state;
    private String stateInfo;

    SeckillStatEnum(Integer state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    public Integer getState() {

        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }
}
