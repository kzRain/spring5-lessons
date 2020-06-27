package kz.cf.spring5.lesson8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

@Service("messageListener")
public class SimpleMessageListener{
    private static final Logger logger = LoggerFactory.getLogger(SimpleMessageListener.class);

    @JmsListener(destination = "prospring5", containerFactory = "jmsListenerContainerFactory")
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;

        try {
            logger.info(">>> Received: " + textMessage.getText());
        } catch (JMSException ex) {
            logger.error("JMS error", ex);
        }
    }
}
