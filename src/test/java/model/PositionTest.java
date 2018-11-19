package model;

import com.webcheckers.model.Position;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class

PositionTest {

    /**
     * Test to make sure you don't have co-ordinates on the board beyong 0-7 range
     */

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void ctr_postion_tooBig(){

        final Position position = new Position(10,10);
    }


    /**
     * Test to make sure white boxes are not valid position on board
     */

    @Ignore
    @Test()
    public void check_invalid_position_on_board(){

        final Position CuT = new Position(1,1);

        Assert.assertFalse("Test Failed due (1,1) being not identified as invalid on the board",CuT.isValidPosition());
    }



    /**
     * Test to make sure black boxes are  valid position on board
     */

    @Ignore
    @Test()
    public void check_valid_position_on_board(){

        final Position CuT = new Position(0,1);

        Assert.assertTrue("Test Failed due (0,1) being not identified as valid on the board",CuT.isValidPosition());
    }







}
