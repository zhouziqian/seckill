package com.zhouqi.dto;

import java.util.Date;

/**
 * 暴露秒杀接口地址DTO
 */
public class ExposerDto {
    //是否开启秒杀
    private Boolean exposed;

    //加密措施
    private String md5;

    private  Long seckillId;

    //当前系统时间（毫秒）
    private Date now;

    //秒杀开启时间
    private Date start;

    //秒杀结束时间
    private Date end;

    public ExposerDto(Boolean exposed, Long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    public ExposerDto(Boolean exposed, Long seckillId, Date now, Date start, Date end) {

        this.exposed = exposed;
        this.seckillId = seckillId;
        this.now = now;
        this.start = start;
        this.end = end;
    }

    public ExposerDto(Boolean exposed, String md5, Long seckillId) {

        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    @Override
    public String toString() {
        return "ExposerDto{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }

    public Boolean getExposed() {
        return exposed;
    }

    public void setExposed(Boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Date getNow() {
        return now;
    }

    public void setNow(Date now) {
        this.now = now;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
