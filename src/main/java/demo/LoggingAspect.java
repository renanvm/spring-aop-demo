package demo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* demo.ShoppingCart.checkout(..))")
    public void beforeLogger(JoinPoint jp) {
        System.out.println(jp.getSignature());
        System.out.println("Before Loggers with arg: " + jp.getArgs()[0].toString() );
    }

    @After("execution(* *.*.checkout(..))")
    public void afeterLogger() {
        System.out.println("After Loggers");
    }

}
