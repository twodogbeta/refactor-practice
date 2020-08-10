
package com.twu.refactoring.impl;

import com.twu.refactoring.Direction;
import com.twu.refactoring.IDirection;

public class East implements IDirection {

    @Override
    public Direction turnLeft() {
        return new Direction('N');
    }

    @Override
    public Direction turnRight() {
        return new Direction('S');
    }
}