package icu.xuyijie.myfirstspringboot.config;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author 徐一杰
 * @date 2024/12/4 8:46
 * @description AOP 日志拦截
 */
@Aspect
@Component
@Slf4j
public class LogAspect {

    @Pointcut("execution(* icu.xuyijie.myfirstspringboot.controller..*.*(..))")
    public void logPointCut() {

    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();

        log.info("请求路径：{}", request.getRequestURI());
        log.info("请求方式：{}", request.getMethod());
        log.info("后台路径：{}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());

        String paramString = Arrays.toString(joinPoint.getArgs());
        log.info("请求参数：{}", paramString);
    }

    @AfterReturning(returning = "returnValue", pointcut = "logPointCut()")
    public void doAfterReturning(Object returnValue) {
        log.info("返回值：{}", returnValue);
    }

    @Around("logPointCut()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long period = System.currentTimeMillis() - startTime;
        log.info("方法耗时：{} ms", period);

        return proceed;
    }

}
//@Aspect 面向切面编程注解，通常应用在类上
//@Pointcut Pointcut是植入Advice的触发条件。每个Pointcut的定义包括2部分，一是表达式，二是方法签名。方法签名必须是 public及void型。可以将Pointcut中的方法看作是一个被Advice引用的助记符，因为表达式不直观，因此我们可以通过方法签名的方式为 此表达式命名。因此Pointcut中的方法只需要方法签名，而不需要在方法体内编写实际代码
//@Around：环绕增强，在被通知的方法调用之前和调用之后执行自定义的方法
//@Before：在目标方法调用之前调用通知
//@AfterReturning：在目标方法成功执行之后调用通知
//@AfterThrowing：在目标方法抛出异常之后调用通知
//@After: 在目标方法完成之后调用通知，不管是抛出异常或者正常退出都会执行
