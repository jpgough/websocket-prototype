package com.jpgough.websocket.server;

import com.jpgough.websocket.server.handlers.DevNullWebSocketHandler;
import com.jpgough.websocket.server.handlers.LargeFileWebSocketHandler;
import com.jpgough.websocket.server.handlers.SimpleAckWebSocketHandler;
import com.jpgough.websocket.server.handlers.SmallFileWebSocketHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(new LargeFileWebSocketHandler(), "/100mb").setAllowedOrigins("*");
        webSocketHandlerRegistry.addHandler(new SmallFileWebSocketHandler(), "/1mb").setAllowedOrigins("*");
        webSocketHandlerRegistry.addHandler(new SimpleAckWebSocketHandler(), "/ack").setAllowedOrigins("*");
        webSocketHandlerRegistry.addHandler(new DevNullWebSocketHandler(), "/ignore").setAllowedOrigins("*");
    }
}
