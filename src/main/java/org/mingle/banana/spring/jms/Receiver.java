/**
 * Copyright (c) 2015, Mingle. All rights reserved.
 */
package org.mingle.banana.spring.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;

/**
 * 消息接收者
 * 
 * @since 1.8
 * @author Mingle
 */
public class Receiver {
	public static Message reveive() {
		Message message = null;
		ConnectionFactory cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
		Connection conn = null;
		Session session = null;
		
		try {
			conn = cf.createConnection();
			conn.start();
			session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			Destination destination = new ActiveMQQueue("mq");
			MessageConsumer consumer = session.createConsumer(destination);
			message = consumer.receive(10000);
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
		
		return message;
	}
	
	public static void main(String[] args) {
		System.out.println(Receiver.reveive());
	}
}
