package com.jpgough.websocket.server;

import com.jpgough.websocket.server.handlers.LargeFileWebSocketHandler;
import com.jpgough.websocket.server.handlers.SimpleAckWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new LargeFileWebSocketHandler(), "/100mb");
        webSocketHandlerRegistry.addHandler(new LargeFileWebSocketHandler(), "/1mb");
        webSocketHandlerRegistry.addHandler(new SimpleAckWebSocketHandler(), "/ack");
    }
}
