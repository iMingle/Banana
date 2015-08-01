/**
 * Copyright (c) 2015, Mingle. All rights reserved.
 */
package org.mingle.banana.spring.jms;

import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
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
public class JMSSender {
	@Inject
	protected JmsTemplate jmsTemplate;
	
	@Test
	public void send() {
		try {
			jmsTemplate.send(new MessageCreator() {
				
				public Message createMessage(Session session) throws JMSException {
					return session.createTextMessage("Hello");
				}
			});
		} catch (JmsException e) {
			e.printStackTrace();
		}
	}
	
}
