package com.cjt.study.basic.server.test.mq;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class TestStreamMessageSender {

	public static void main(String[] args) {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, ActiveMQConnection.DEFAULT_BROKER_URL);
		try {
			Connection connection = factory.createConnection();
			Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			Destination destination = session.createQueue("firstMQ");
			MessageProducer producer = session.createProducer(destination);
			Message message = session.createStreamMessage();
			producer.send(destination, message);
		} catch (JMSException e) {
			e.printStackTrace();
		}

	}
}
