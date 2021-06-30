package com.jpgough.websocket.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new LargeFileWebSocketExample(), "/100mb");
        webSocketHandlerRegistry.addHandler(new SimpleAckWebSocketExample(), "/ack");
    }
}
