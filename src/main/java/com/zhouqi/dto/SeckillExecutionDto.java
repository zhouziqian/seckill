package com.zhouqi.dto;

import com.zhouqi.entity.SuccessKilled;
import com.zhouqi.enums.SeckillStatEnum;

/**
 * 封装执行秒杀后的结果:是否秒杀成功
 */
public class SeckillExecutionDto {
    private Long seckillId;
    //秒杀执行结果的状态
    private Integer state;
    //状态的明文标识
    private String stateInfo;
    //当秒杀成功时，需要传递秒杀成功的对象回去
    private SuccessKilled successKilled;

    //秒杀成功返回所有信息

    public SeckillExecutionDto(Long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {
        this.seckillId = seckillId;
        this.state=statEnum.getState();
        this.stateInfo=statEnum.getStateInfo();
        this.successKilled = successKilled;
    }

    //秒杀失败

    public SeckillExecutionDto(Long seckillId,SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.state=statEnum.getState();
        this.stateInfo=statEnum.getStateInfo();
    }

    @Override
    public String toString() {
        return "SeckillExecutionDto{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilled=" + successKilled.toString() +
                '}';
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
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

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}
