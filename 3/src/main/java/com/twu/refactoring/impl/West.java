
package com.twu.refactoring.impl;

import com.twu.refactoring.Direction;
import com.twu.refactoring.IDirection;

public class West implements IDirection {

    @Override
    public Direction turnLeft() {
        return new Direction('S');

    }

    @Override
    public Direction turnRight() {
        return new Direction('N');

    }
}