package com.chan.girl.exception;

import com.chan.girl.emuns.ResultEmun;

public class GirlException extends RuntimeException{    //Spring事务只对运行时异常进行回滚 抛出Exceptin不回滚
    //异常状态码
    private Integer code;

    public GirlException(ResultEmun resultEmun) {
        super(resultEmun.getMsg());
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
