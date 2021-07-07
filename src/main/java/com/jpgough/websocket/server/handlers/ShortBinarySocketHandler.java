package com.jpgough.websocket.server.handlers;

import org.springframework.web.socket.BinaryMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.BinaryWebSocketHandler;

import java.nio.charset.StandardCharsets;

public class ShortBinarySocketHandler extends BinaryWebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        String hello = "Hello";
        session.sendMessage(new BinaryMessage(hello.getBytes(StandardCharsets.UTF_8)));
    }
}
