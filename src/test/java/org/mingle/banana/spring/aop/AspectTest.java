package org.mingle.banana.spring.aop;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/aop/spring-aop.xml")
public class AspectTest {
	@Inject
	private Juggler juggler;
	@Inject
	private Magician magician;

	@Test
	public void audienceShouldApplaud() throws Exception {
		juggler.perform();
		magician.interceptThoughts("Think Content");
	}

}
