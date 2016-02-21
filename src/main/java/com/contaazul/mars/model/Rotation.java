package com.contaazul.mars.model;

public enum Rotation {

    LEFT('L'),
    RIGHT('R');

    public Character rotationValue;

    Rotation(Character rotationValue) {
        this.rotationValue = rotationValue;
    }

}
