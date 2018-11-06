package model;

import com.webcheckers.model.Message;
import com.webcheckers.model.MessageTypeEnum;
import org.junit.Test;
import static org.junit.Assert.*;
public class MessageTest {
    Message message;

    @Test
    public void getText(){
        message.setText("TestMessage");
        assertEquals("TestMessage",message.getText());
    }

    @Test
    public void setType(){
        message.setType(MessageTypeEnum.info);
        assertEquals(MessageTypeEnum.info,message.getType());
    }
}
