package com.contaazul.mars;


import com.contaazul.mars.model.Area;
import com.contaazul.mars.model.Position;
import com.contaazul.mars.model.factory.AreaFactory;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class SquareAreaTest {


    @Test
    public void squareAreaTest(){
        Area area = new AreaFactory().createArea();
        assertNotNull(area);
        assertTrue(area.isPositionInArea(new Position(0, 0)));
        assertTrue(area.isPositionInArea(new Position(2, 3)));
        assertTrue(area.isPositionInArea(new Position(4, 4)));

        assertFalse(area.isPositionInArea(new Position(0, 5)));
        assertFalse(area.isPositionInArea(new Position(5, 0)));
        assertFalse(area.isPositionInArea(new Position(5, 5)));

        assertFalse(area.isPositionInArea(new Position(-1,  0)));
        assertFalse(area.isPositionInArea(new Position( 0, -1)));
        assertFalse(area.isPositionInArea(new Position(-1, -1)));
    }

}
