package com.chan.girl.handle;

import com.chan.girl.Util.ResultUtil;
import com.chan.girl.domain.Result;
import com.chan.girl.emuns.ResultEmun;
import com.chan.girl.exception.GirlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {

    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);


    @ExceptionHandler(value = Exception.class) //捕获Exception.class的异常
    @ResponseBody   //返回json
    public Result handle(Exception e) {
        if(e instanceof  GirlException) {
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }
        logger.error("[系统异常]{}",e);
        return ResultUtil.error(ResultEmun.UNKONW_ERROR);
    }
}
