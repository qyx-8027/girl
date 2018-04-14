package com.chan.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {

    @Autowired
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.chan.girl.controller.GirlController.*(..))")
    public void log() {}

    //@Before(("execution(public * com.chan.girl.controller.GirlController.*(..))"))
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        //System.out.println("执行doBefore()..拦截所有访问GirlController类的Http请求...");
        logger.info("----执行doBefore()..拦截所有访问GirlController类的Http请求...----");

        ServletRequestAttributes attributes =
                (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURL());
        //method
        logger.info("method={}",request.getMethod());
        //ip 主机名
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    @After("log()")
    public void doAfter() {
        logger.info("----执行doAfter()...----");
    }

    @AfterReturning(pointcut = "log()",returning = "object")
    public void doAfgerReturning(Object object) {
        logger.info("----执行doAfterReturning()...----");
        logger.info("response={}",object.toString());
    }
}
