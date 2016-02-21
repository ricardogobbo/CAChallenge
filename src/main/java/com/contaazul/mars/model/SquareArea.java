package com.contaazul.mars.model;


public class SquareArea extends Area {

    private Position minPosition;
    private Position maxPosition;

    public SquareArea(Position minPosition, Position maxPosition) {
        this.minPosition = minPosition;
        this.maxPosition = maxPosition;
    }

    public Position getMinPosition() {
        return minPosition;
    }

    public void setMinPosition(Position minPosition) {
        this.minPosition = minPosition;
    }

    public Position getMaxPosition() {
        return maxPosition;
    }

    public void setMaxPosition(Position maxPosition) {
        this.maxPosition = maxPosition;
    }

    @Override
    public Boolean isPositionInArea(Position position) {
        return minPosition.getX() <= position.getX() && minPosition.getY() <= position.getY() &&
                maxPosition.getX() >= position.getX() && maxPosition.getY() >= position.getY();
    }
}
