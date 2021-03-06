package kz.cf.spring5.lesson8;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;

public class EchoHandler extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage) throws IOException {
        System.out.println("================" + textMessage.asBytes());
        session.sendMessage(new TextMessage(textMessage.getPayload()));
    }
}
