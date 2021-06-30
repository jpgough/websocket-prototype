package com.jpgough.websocket.server;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class HelloController {

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting hello(HelloMessage helloMessage) throws Exception {
        Thread.sleep(1L);
        System.out.println("Invoked Greeting Controller");
        return new Greeting("Hello " + HtmlUtils.htmlEscape(helloMessage.getName()));
    }
}
