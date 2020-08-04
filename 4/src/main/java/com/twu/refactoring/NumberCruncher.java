package com.twu.refactoring;

public class NumberCruncher {
    private final int[] numbers;
    private int count = 0;

    public NumberCruncher(int... numbers) {
        this.numbers = numbers;
    }

    public int countEven() {
        for (int number : numbers) {
            if (number % 2 == 0) count++;
        }
        return count;
    }

    public int countOdd() {
        for (int number : numbers) {
            if (number % 2 == 1) count++;
        }
        return count;
    }

    public int countPositive() {
        for (int number : numbers) {
            if (number >= 0) count++;
        }
        return count;
    }

    public int countNegative() {
        for (int number : numbers) {
            if (number < 0) count++;
        }
        return count;
    }
}
