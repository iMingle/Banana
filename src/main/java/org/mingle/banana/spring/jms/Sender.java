/**
 * Copyright (c) 2015, Mingle. All rights reserved.
 */
package org.mingle.banana.spring.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 * 消息发送者
 * 
 * @since 1.8
 * @author Mingle
 */
public class Sender {
	public static void send(String message) {
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection conn = null;
		Session session = null;
		
		try {
			conn = cf.createConnection();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = new ActiveMQQueue("mq");
			MessageProducer producer = session.createProducer(destination);
			TextMessage textMessage = session.createTextMessage(message);
			producer.send(textMessage);
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			try {
				if (session != null) {
					session.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Sender.send("Hello");
	}
}
