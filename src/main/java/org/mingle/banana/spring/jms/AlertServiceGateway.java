package org.mingle.banana.spring.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.mingle.banana.spring.jdbc.Spittle;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.core.support.JmsGatewaySupport;

public class AlertServiceGateway extends JmsGatewaySupport implements
		AlertService {
	public void sendSpittleAlert(final Spittle spittle) {
		getJmsTemplate().send("spittle.alert.queue", new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				return session.createObjectMessage(spittle);
			}
		});
	}
}
