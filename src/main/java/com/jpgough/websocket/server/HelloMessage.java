package com.jpgough.websocket.server;

public class HelloMessage {
    private String name;

    public HelloMessage() {

    }

    public HelloMessage(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String setName(String name) {
        return this.name = name;
    }
}
