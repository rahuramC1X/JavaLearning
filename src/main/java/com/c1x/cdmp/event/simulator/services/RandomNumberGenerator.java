package com.c1x.cdmp.event.simulator.services;

import java.util.Arrays;
import java.util.Random;

public class RandomNumberGenerator {

    private static final Random random = new Random();

    public static int[] generateRandomUserCount(int size) {
        int[] randomUserCount = new int[size];

        for (int i = 0; i < size; i++) {
            randomUserCount[i] = getRandomValue();
        }
        return randomUserCount;
    }

    public static int[] generateRandomConversions(int[] userCounts) {
        int size = userCounts.length;
        int[] randomConvertedUsers = new int[size];

        for (int i = 0; i < size; i++) {
            randomConvertedUsers[i] = getRandomValue(userCounts[i]);
        }
        return randomConvertedUsers;
    }

    private static int getRandomValue() {
        int lowerBound = 10000;
        int upperBound = 20000;
        return random.nextInt(upperBound - lowerBound + 1) + lowerBound;
    }

    private static int getRandomValue(int maxValue) {
        return random.nextInt(maxValue) + 1;
    }

    public static void main(String[] args) {
        // Example usage
        int[] userCounts = generateRandomUserCount(5);
        int[] conversions = generateRandomConversions(userCounts);

        // Print the results
        System.out.println("User Counts: " + Arrays.toString(userCounts));
        System.out.println("Conversions: " + Arrays.toString(conversions));
    }
}
