package com.kelaslatihan.utils;

public class RandomNumber {
    public static long getRandom(long min, long max) {
        long number = min + (long) (Math.random() * (max - min));
        return number;
    }
}
