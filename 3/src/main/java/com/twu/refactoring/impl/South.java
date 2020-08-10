package com.twu.refactoring.impl;

import com.twu.refactoring.Direction;
import com.twu.refactoring.IDirection;

public class South implements IDirection {

    @Override
    public Direction turnLeft() {
        return new Direction('E');

    }

    @Override
    public Direction turnRight() {
        return new Direction('W');

    }
}