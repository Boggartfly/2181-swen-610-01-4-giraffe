package com.webcheckers.model;

public class Message {

    public String text;

    public MessageTypeEnum type;

    public Message(String text, MessageTypeEnum messageType) {
        this.text = text;
        this.type = messageType;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public MessageTypeEnum getType() {
        return type;
    }

    public void setType(MessageTypeEnum messageType) {
        this.type = messageType;
    }


}
