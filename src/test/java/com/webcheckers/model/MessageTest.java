package com.webcheckers.model;

import static org.junit.Assert.*;

import com.webcheckers.model.Message;
import com.webcheckers.model.MessageTypeEnum;
import org.junit.Test;

/**
 * @Author Parth Sane
 */
public class MessageTest {
    private Message message;
    private String testMessage = "Test";
    public MessageTest(){
        message = new Message(testMessage, MessageTypeEnum.info);
    }

    @Test
    public void setText(){
        message.setText(testMessage);
    }

    @Test
    public void getText(){
        assertEquals(message.getText(),testMessage);
    }

    @Test
    public void setEnumType(){
        message.setType(MessageTypeEnum.info);
    }

    @Test
    public void getEnumType(){
        assertEquals(message.getType(),MessageTypeEnum.info);
    }

}
