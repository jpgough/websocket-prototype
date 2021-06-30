package com.jpgough.websocket.server;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Random;

@Component
public class LargeFileWebSocketExample extends TextWebSocketHandler {

    private Random random = new Random();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        System.out.println("Establishing Session: " + session);
        StringBuilder builder;

        for(int i=0; i < 10; i++) {
            builder = new StringBuilder();
            for(int j=0; j < 10_000_000; j++) {
                builder.append((char) ('a' + random.nextInt(26)));
            }
            session.sendMessage(new TextMessage(builder.toString()));
        }

        session.close();
    }
}
