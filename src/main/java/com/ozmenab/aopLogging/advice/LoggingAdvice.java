package com.ozmenab.aopLogging.advice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class LoggingAdvice {
    private Logger log = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.ozmenab.aopLogging.api.controllers.*.*(..))")
    private void forControllerPackage(){}

    @Pointcut("execution(* com.ozmenab.aopLogging.business.abstracts.*.*(..))")
    private void forBusinessPackage(){}

    @Pointcut("execution(* com.ozmenab.aopLogging.dataAccess.*.*(..))")
    private void forDataAccessPackage(){}

    @Pointcut("forControllerPackage() || forBusinessPackage() || forDataAccessPackage()")
    private void forAppFlow(){}

    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint){
        //calling method
        String methodName = joinPoint.getSignature().toShortString();
        log.info("Before, calling method: "+methodName);

        Object[] args = joinPoint.getArgs();
        for(Object arg: args){
            log.info("argument: "+arg);
        }
    }

    @AfterReturning(pointcut = "forAppFlow()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().toShortString();
        log.info("After, calling method: "+methodName);
        log.info("result: "+result);
    }
}
