package com.contaazul.mars.model;

/**
 * Created by Gobbo on 19/02/2016.
 */
public class Position {

    private Integer x, y;

    public Position(Integer x, Integer y) {
        this.setX(x);
        this.setY(y);
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position){
            Position another = (Position) obj;
            return another.getX().equals(this.getX()) && another.getY().equals(this.getY());
        }

        return false;
    }

    @Override
    public String toString() {
        return "COORD [" + this.getX() + ", " + this.getY() + "]";
    }
}
