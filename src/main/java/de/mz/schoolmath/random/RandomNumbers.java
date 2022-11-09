package de.mz.schoolmath.random;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class RandomNumbers {

    private static final Random RANDOM = new Random();

    private RandomNumbers() {}

    public static List<Integer> getRandomNumbers(int startNumber, int endNumber, int rowSize) {
        final List<Integer> list = new ArrayList<>(rowSize);

        for (int i = startNumber; i <= rowSize; i++) {
            int result = getRandomNumber(endNumber);
            list.add(result);
        }
        return list;
    }

    public static int getRandomNumber(int endNumber) {
        return 1 + RANDOM.nextInt(endNumber);
    }
}
