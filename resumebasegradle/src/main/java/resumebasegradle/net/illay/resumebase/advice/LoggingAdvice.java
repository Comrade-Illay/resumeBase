package resumebasegradle.net.illay.resumebase.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Aspect
@Component
public class LoggingAdvice {
    
	Logger log = LoggerFactory.getLogger(LoggingAdvice.class);
	
	/**
	 * Tells where advice should be execute
	 * For getAll() method
	 */
	@Pointcut(value = "execution(* resumebasegradle.net.illay.resumebase.service.ResumeServiceImpl.getAll(..) )")
	public void restPointCut() {
		
	}
	
	/**
	 * Tells where advice should be execute
	 * For getAll() method
	 */
	@Pointcut(value = "execution(* resumebasegradle.net.illay.resumebase.exception.*.*(..) )")
	public void exceptionPointCut() {
		
	}
   /**
    * Method for logging getAll() method on "info"-level
    * @param pjp
    * @return
    * @throws Throwable
    */
	@Around("restPointCut()")
	public Object applictionLogger(ProceedingJoinPoint pjp) throws Throwable {

		ObjectMapper mapper = new ObjectMapper();
		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();
		Object[] array = pjp.getArgs();

		log.info("method invoke " + className + " : " + methodName + "()" + "arguments:"
				+ mapper.writeValueAsString(array));

		Object object = pjp.proceed();

		log.info(className + " : " + methodName + "()" + "Responce:" + mapper.writeValueAsString(object));

		return object;
	}
	
	/**
	 * Method for logging exceptions
	 * @param pjp
	 * @return
	 * @throws Throwable
	 */
	@Around("exceptionPointCut()")
	public Object exceptionLogger(ProceedingJoinPoint pjp) throws Throwable {

		String methodName = pjp.getSignature().getName();
		String className = pjp.getTarget().getClass().toString();

		Object object = pjp.proceed();

		log.error(className + " : " + methodName + "()" + "Result: Something gone wrong");

		return object;
	}

}
