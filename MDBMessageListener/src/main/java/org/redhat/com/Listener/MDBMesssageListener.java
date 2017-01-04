package org.redhat.com.Listener;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.EJBException;
import javax.ejb.MessageDriven;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import org.jboss.ejb3.annotation.ResourceAdapter;

@MessageDriven(activationConfig = {
		@ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
		@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
		@ActivationConfigProperty(propertyName = "destination", propertyValue = "queue.HELLOWORLDMDBQueue") }) // Note
																												// the
																												// physical
																												// name
																												// of
																												// the
																												// queue
@ResourceAdapter("activemq-rar.rar")
public class MDBMesssageListener implements MessageListener {

	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;
	@Resource(mappedName = "java:/queue/HELLOWORLDMDBQueue") // Note the mapped
																// name of the
																// queue
	private Destination queue;
	private Connection connection;

	public void init() throws JMSException {
		connection = connectionFactory.createConnection();
		connection.start();
		// System.out.println("Say hello to Message driven bean");
		// sendMessage("Text message Test Dinesh");
	}

	public void destroy() throws JMSException {
		connection.close();
	}

/*	private void sendMessage(String text) throws JMSException {
		Session session = null;
		MessageProducer sender = null;
		try {
			session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
			sender = session.createProducer(queue);
			sender.setDeliveryMode(DeliveryMode.PERSISTENT);

			TextMessage response = session.createTextMessage(text);
			sender.send(response);
		} finally {
			try {
				if (sender != null) {
					sender.close();
				}
			} finally {
				if (session != null) {
					session.close();
				}
			}
		}
	}*/

	public void onMessage(Message message) {
		try {
			init();
			String text = ((TextMessage) message).getText();
			System.out.println("Reply for '" + text + "'");
		} catch (JMSException e) {
			throw new EJBException("Error in JMS operation", e);
		} finally {
			try {
				destroy();
			} catch (JMSException e) {
				throw new EJBException("Error in closing connection", e);
			}
		}

	}

}
