package model;

import com.webcheckers.model.Message;
import com.webcheckers.model.MessageTypeEnum;
import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.*;
public class MessageTest {
    private Message message;

    public MessageTest(){
        message = new Message("Test",MessageTypeEnum.info);
    }

    @Ignore
    @Test
    public void getText(){
        message.setText("TestMessage");
        assertEquals("TestMessage",message.getText());
    }

    @Ignore
    @Test
    public void setType(){
        message.setType(MessageTypeEnum.info);
        assertEquals(MessageTypeEnum.info,message.getType());
    }
}
