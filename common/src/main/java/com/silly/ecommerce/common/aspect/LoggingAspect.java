package com.silly.ecommerce.common.aspect;

import com.silly.ecommerce.common.logger.SeLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Aspect
@Component
@Slf4j
public class LoggingAspect {

    // Pointcut expressions
    public static final String CONTROLLER_EXPRESSION = "execution(* com.silly.ecommerce.*.controller.*.*(..))";


    // Pointcut declaration
    @Pointcut(CONTROLLER_EXPRESSION)
    public void controllerPointcut() {

    }


    // Advice types
    @Around("controllerPointcut()")
    public Object monitorController(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().toString();
        SeLog.info(methodName, "Start monitoring...");

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();

        SeLog.info(methodName, "Stop monitoring with total time {}", stopWatch.getTotalTimeSeconds());
        return result;

    }

}
