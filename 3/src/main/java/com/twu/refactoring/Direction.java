package com.twu.refactoring;

public class Direction {
    private final IDirection direction;

    public Direction(char direction) {
        this.direction = DirectionFactory.getDirection(direction);
    }

    public Direction turnRight() {
        return direction.turnRight();
    }

    public Direction turnLeft() {
        return direction.turnLeft();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        if (direction != direction1.direction) return false;

        return true;
    }


    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
