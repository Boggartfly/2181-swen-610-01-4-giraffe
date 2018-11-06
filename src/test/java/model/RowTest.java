package model;

import com.webcheckers.model.Row;
import org.junit.Test;
import static org.junit.Assert.*;

public class RowTest {
    Row row;
    public RowTest(){
        row = new Row(1);
    }
    @Test
    public void getSpaces(){
        assertNotNull(row.getSpaces());
    }

    @Test
    public void getIndex(){
        row.setIndex(1);
        assertEquals(1,row.getIndex());
    }

    @Test
    public void iterator(){
        assertNotNull(row.iterator());
    }
}
