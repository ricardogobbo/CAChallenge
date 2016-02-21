package com.contaazul.mars.model;

public enum Direction {

    NORTH('N', 0),
    EAST('E', 1),
    SOUTH('S', 2),
    WEST('W', 3);

    public final Integer positionId;
    private final Character directionValue;

    Direction(Character directionValue, Integer positionId) {
        this.directionValue = directionValue;
        this.positionId = positionId;
    }

    public Character getDirectionValue(){
        return directionValue;
    }

    public static Direction[] getDirectionCircle(){
        Direction[] directionCircle = {Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST};
        return directionCircle;
    }
}
