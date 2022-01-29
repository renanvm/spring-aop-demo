package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp) {
        System.out.println("Before Loggers with arg: " + jp.getArgs()[0].toString());
    }

    @After("execution(* *.*.checkout(..))")
    public void afeterLogger() {
        System.out.println("After Loggers");
    }

    @Pointcut("execution(* demo.ShoppingCart.quantity(..))")
    public void afterReturningPointCut() {

    }

    @AfterReturning(pointcut = "afterReturningPointCut()", returning = "retVal")
    public void afterReturning(String retVal) {
        System.out.println("After returning:" + retVal);
    }

}
