package com.chan.girl.emuns;

import org.springframework.stereotype.Component;

public enum ResultEmun {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(200,"成功"),
    PRIMARY_SCHOOL(101,"还在上小学"),
    MIDDLE_SCHOOL(102,"可能在上初中"),
    HIGHT_SCHOOL(103,"可能在上高中")
    ;

    private Integer code;

    private String msg;

    ResultEmun(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
