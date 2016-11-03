package com.cjt.study.basic.server.test.mq;

import java.text.MessageFormat;
import java.util.Date;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MessageSender {
	public static void main(String[] args) {
		// 连接工厂
		ConnectionFactory connectionFactory;
		// jms连接
		Connection connection = null;
		Session session;// 一次会话
		Destination destination;
		MessageProducer producer;
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		try {
			connection = connectionFactory.createConnection();
			connection.start();
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			destination = session.createQueue("firstMQ");
			producer = session.createProducer(destination);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			sendMessage(session, producer);
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
		} finally {
			if (null != connection) {
				try {
					connection.close();
				} catch (JMSException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void sendMessage(Session session, MessageProducer producer) throws JMSException {
		for (int i = 1; i <= 6000; i++) {
			@SuppressWarnings("deprecation")
			TextMessage textMessage = session
					.createTextMessage(MessageFormat.format("这是第{0}条MQ消息!{1}发送!", i, new Date().toLocaleString()));
			System.out.println(MessageFormat.format("这是第{0}条MQ消息!", i));
			producer.send(textMessage);
		}
	}
}
