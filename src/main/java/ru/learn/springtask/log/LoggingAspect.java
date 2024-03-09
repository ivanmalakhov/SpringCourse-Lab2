package ru.learn.springtask.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.StringJoiner;

@Aspect
@Component
public class LoggingAspect {
    @Autowired
    Loggerable logger;
    @Around("@annotation(LogTransformation)")
    public Object logArround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        LocalDateTime begin = LocalDateTime.now();
        Object result = joinPoint.proceed();
        LocalDateTime end = LocalDateTime.now();


        StringJoiner joiner = new StringJoiner(",");
        joiner
                .add(begin.toString())
                .add(end.toString())
                .add(joinPoint.getSignature().getName())
                .add(Arrays.toString(args))
                .add(String.valueOf(result));

        logger.logData(joiner.toString());

        return result;
    }
}
