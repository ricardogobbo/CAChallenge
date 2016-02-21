package com.contaazul.mars.model;

public class Robot {

    private Position position;
    private Direction direction;

    public Robot(Position initialPosition, Direction initialDirection) {
        this.setPosition(initialPosition);
        this.setDirection(initialDirection);
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public void rotate(Rotation rotation) {

        switch (rotation){
            case LEFT:
                // Add 4 to prevent AIOBException
                Direction directionToLeft =
                        Direction.getDirectionCircle()[(this.direction.positionId - 1 + 4) % 4];
                this.setDirection(directionToLeft);
                break;
            case RIGHT:
                Direction directionToRight =
                        Direction.getDirectionCircle()[(this.direction.positionId + 1) % 4];
                this.setDirection(directionToRight);
                break;
        }
    }

    public void stepMove() {
        switch (direction){
            case NORTH:
                position.setY(position.getY() + 1);
                break;
            case EAST:
                position.setX(position.getX() + 1);
                break;
            case SOUTH:
                position.setY(position.getY() - 1);
                break;
            case WEST:
                position.setX(position.getX() - 1);
                break;
        }
    }

    public Position nextStepPosition() {
        switch (direction){
            case NORTH:
                return new Position(position.getX(), position.getY() + 1);
            case EAST:
                return new Position(position.getX() + 1, position.getY());
            case SOUTH:
                return new Position(position.getX(), position.getY() - 1);
            case WEST:
                return new Position(position.getX() - 1, position.getY());
        }

        return null;
    }

    @Override
    public String toString() {
        return "(" + position.getX() + ", " + position.getY() + ", " +
                direction.getDirectionValue() + ")";
    }
}
