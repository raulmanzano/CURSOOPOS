package es.uniovi;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLog {
	@Before("execution(* es.uniovi.service.impl.*.*(..))")
	public void log(JoinPoint joinPoint) throws Throwable {
		System.out.println("--> Antes de ejecutar " + joinPoint);	
	}
	
	
}
