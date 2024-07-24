package com.service.productcatalogue.log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeTrackerApplication {

    Logger logger=LoggerFactory.getLogger(ExecutionTimeTrackerApplication.class);

    @Around("@annotation(com.service.productcatalogue.log.ExecutionTimeTrackerAppAnnotation)")
    public Object trackTime(ProceedingJoinPoint pjp) throws Throwable {
        long startTime=System.currentTimeMillis();
        Object obj=pjp.proceed();
        long endTime=System.currentTimeMillis();
        logger.info("Method name"+pjp.getSignature()+" time taken to execute : "+(endTime-startTime));
        return obj;
    }

}