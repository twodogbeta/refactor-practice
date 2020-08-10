
package com.twu.refactoring.impl;

import com.twu.refactoring.Direction;
import com.twu.refactoring.IDirection;

public class North implements IDirection {

    @Override
    public Direction turnLeft() {
        return new Direction('W');
    }

    @Override
    public Direction turnRight() {
        return new Direction('E');
    }
}