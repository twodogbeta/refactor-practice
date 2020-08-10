package com.twu.refactoring;

import com.twu.refactoring.impl.East;
import com.twu.refactoring.impl.North;
import com.twu.refactoring.impl.South;
import com.twu.refactoring.impl.West;

public class DirectionFactory {

    public static IDirection getDirection(char direction) {
        switch (direction) {
            case 'E':
                return new East();
            case 'W':
                return new West();
            case 'N':
                return new North();
            case 'S':
            default:
                throw new IllegalArgumentException();
        }
    }

}