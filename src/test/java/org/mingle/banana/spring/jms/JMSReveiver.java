/**
 * Copyright (c) 2015, Mingle. All rights reserved.
 */
package org.mingle.banana.spring.jms;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * 
 * @since 1.8
 * @author Mingle
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/jms/messaging-context.xml")
public class JMSReveiver {
	@Inject
	protected JmsTemplate jmsTemplate;
	
	@Test
	public void receive() {
		try {
			System.out.println(jmsTemplate.receive());
		} catch (JmsException e) {
			e.printStackTrace();
		}
	}
}
