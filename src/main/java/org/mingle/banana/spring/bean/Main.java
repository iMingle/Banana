package org.mingle.banana.spring.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;

public class Main {
	public static void main(String[] args) throws PerformanceException {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("spring/bean/bean.xml");

		BraveKnight knight = (BraveKnight) context.getBean("knight");
		knight.embarkOnQuest();
		
		Performer performerS1 = (Performer) context.getBean("dukeSingleton");
		Performer performerS2 = (Performer) context.getBean("dukeSingleton");
		Assert.isTrue(performerS1 == performerS2);
		performerS1.perform();
		
		Performer performerS3 = (Performer) context.getBean("dukePrototype");
		Performer performerS4 = (Performer) context.getBean("dukePrototype");
		Assert.isTrue(performerS3 != performerS4);
		
		Performer performerFM = (Performer) context.getBean("dukeFactoryMethod");
		performerFM.perform();
		
		Performer performerProperty = (Performer) context.getBean("dukeProperty");
		System.out.println(performerProperty);
		Performer performerPropertyP = (Performer) context.getBean("dukePropertyP");
		performerPropertyP.perform();
	}
}
