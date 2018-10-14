package se.william.mvcexemple.shoppinglist.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

	// setup logger
	private Logger myLogger = LogManager.getLogger(getClass().getName());
	
	// setup pointcut declarations
	@Pointcut("execution(* se.william.mvcexemple.shoppinglist.controller.*.*(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* se.william.mvcexemple.shoppinglist.service.*.*(..))")
	private void forServicePackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage()")
	private void forAppFlow() {}
	
	// add @Before advice ... JoinPoint is a handler for getting methods and arguments.
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>> in @Before: calling method: " +theMethod);
		
		// display the arguments to the method
		Object[] theArgs = theJoinPoint.getArgs();
		
		for (Object object : theArgs) {
			myLogger.info("====>> in @Before: arguments: " +object);
		}
		
	}
	
	// add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult"
			)
	public void after(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>> in @AfterReturning: from method: " +theMethod);
		
		// display data returned
		myLogger.info("====>> result: " +theResult);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
