package org.mingle.banana.spring.jms;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;

import org.mingle.banana.spring.jdbc.Spittle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.springframework.stereotype.Component;

@Component
public class AlertMessageReceiver {
	@Autowired
	JmsTemplate jmsTemplate;

	public Spittle getAlert() {
		try {
			ObjectMessage receivedMessage = (ObjectMessage) jmsTemplate
					.receive();

			return (Spittle) receivedMessage.getObject();
		} catch (JMSException jmsException) {
			throw JmsUtils.convertJmsAccessException(jmsException);
		}
	}
}
