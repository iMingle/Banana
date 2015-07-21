package org.mingle.banana.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 切面
 * 
 * @since 1.8
 * @author Mingle
 */
@Aspect
public class Audience {
	@Pointcut("execution(* org.mingle.banana.spring.aop.Performer.perform(..))")
	public void performance() {}
	
	/**
	 * 表演之前
	 */
	@Before("performance()")
	public void takeSeats() {
		System.out.println("The audience is taking their seats.");
	}

	/**
	 * 表演之前
	 */
	@Before("performance()")
	public void turnOffCellPhones() {
		System.out.println("The audience is turning off their cellphones");
	}

	/**
	 * 表演之后
	 */
	@AfterReturning("performance()")
	public void applaud() {
		System.out.println("CLAP CLAP CLAP CLAP CLAP");
	}

	/**
	 * 表演失败之后
	 */
	@AfterThrowing("performance()")
	public void demandRefund() {
		System.out.println("Boo! We want our money back!");
	}

	/**
	 * 环绕通知
	 * 
	 * @param joinpoint
	 */
	@Around("performance()")
	public void watchPerformance(ProceedingJoinPoint joinpoint) {
		try {
			System.out.println("The audience is taking their seats.");
			System.out.println("The audience is turning off their cellphones");
			long start = System.currentTimeMillis();

			joinpoint.proceed();

			long end = System.currentTimeMillis();
			System.out.println("CLAP CLAP CLAP CLAP CLAP");
			System.out.println("The performance took " + (end - start)
					+ " milliseconds.");
		} catch (Throwable t) {
			System.out.println("Boo! We want our money back!");
		}
	}
}