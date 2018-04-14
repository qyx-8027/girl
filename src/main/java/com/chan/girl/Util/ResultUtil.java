package com.chan.girl.Util;

import com.chan.girl.domain.Result;
import com.chan.girl.emuns.ResultEmun;

public class ResultUtil {

    public static Result success(ResultEmun resultEmun,Object object) {
        return new Result(resultEmun.getCode(),resultEmun.getMsg(),object);
    }

    public static Result success(ResultEmun resultEmun) {
        return success(resultEmun,null);
    }

    public static Result error(ResultEmun resultEmun) {
        return new Result(resultEmun.getCode(),resultEmun.getMsg(),null);
    }

    public static Result error(Integer code, String msg) {
        return new Result(code, msg,null);
    }



}
