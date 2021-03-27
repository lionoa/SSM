package com.example.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.text.SimpleDateFormat;
import java.util.Date;

@Aspect
public class ServiceLog {

    @Around("execution(* com.example.service.BookServiceImpl.*(..))")
    public Object log(ProceedingJoinPoint point) throws Throwable {
        String methodName = point.getSignature().getName();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        Date before = new Date();
        System.out.println(ft.format(before) + "方法：" + methodName + "执行开始");
        Object o = point.proceed();
        Date after = new Date();
        System.out.println(ft.format(after) + "方法：" + methodName + "执行结束");
        return o;

    }
}
