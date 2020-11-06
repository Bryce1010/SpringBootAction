package com.example.demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
public class AopLog {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    ThreadLocal<Long>startTime=new ThreadLocal<>();

    @Pointcut("execution(public * com.example..*.*(..))")
    public void aopWebLog(){

    }

    @Before("aopWebLog()")
    public void doBefore(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //记录下请求内容
        logger.info("URL:"+request.getRequestURI().toString());
        logger.info("HTTP方法:"+request.getMethod());
        logger.info("IP地址:"+request.getRemoteAddr());
        logger.info("类的方法:"+joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        logger.info("参数:"+request.getQueryString());
    }

    @AfterReturning(pointcut = "aopWebLog()",returning = "retObject")
    public void doAfterReturning(Object retObject){
        logger.info("应答值:"+retObject);
        logger.info("费时:"+(System.currentTimeMillis()-startTime.get()));
    }

    @AfterThrowing(pointcut = "aopWebLog()",throwing = "ex")
    public void doAfterThrowingLogger(JoinPoint joinPoint,Exception ex){
        logger.error("执行"+"异常",ex);
    }

}
