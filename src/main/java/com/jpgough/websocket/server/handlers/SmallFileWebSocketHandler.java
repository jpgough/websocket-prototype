package com.jpgough.websocket.server.handlers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Random;

@Component
public class SmallFileWebSocketHandler extends TextWebSocketHandler {

    private static final Logger log = LoggerFactory.getLogger(SmallFileWebSocketHandler.class);

    private Random random = new Random();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        log.info("Establishing Session: [{}]", session);
        StringBuilder builder;

        builder = new StringBuilder();
        for(int j=0; j < 1_000_000; j++) {
            builder.append((char) ('a' + random.nextInt(26)));
        }
        session.sendMessage(new TextMessage(builder.toString()));

        session.close();
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
        log.error("Error occurred on transport", exception);
    }
}
