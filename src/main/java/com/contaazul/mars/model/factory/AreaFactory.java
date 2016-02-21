package com.contaazul.mars.model.factory;

import com.contaazul.mars.model.Area;
import com.contaazul.mars.model.Position;
import com.contaazul.mars.model.SquareArea;

public class AreaFactory {

    public Area createArea(){
        Position minPosition = new Position(0, 0);
        Position maxPosition = new Position(4, 4);
        return new SquareArea(minPosition, maxPosition);
    }

}

