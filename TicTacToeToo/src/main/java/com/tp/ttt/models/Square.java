package com.tp.ttt.models;

public enum Square {

    // ENUMS are your friend :)

    X(1),
    O(10),
    SPACE(0);

    int value;

    Square(int value){
        this.value = value;
    }
}

