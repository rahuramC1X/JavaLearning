package com.c1x.cdmp.event.simulator.services;

import java.util.Arrays;
import java.util.Random;

public class ConversionSimulatorService {

    static Random random = new Random();
    private static int lowerBound = 10000;

    private static int upperBound = 20000;
    private String campaignId = "campaign_"+random.nextInt(upperBound - lowerBound) + lowerBound;

    private static int getRandomValue() {
        int lowerBound = 10000;
        int upperBound = 20000;
        return (int) ((Math.random() * (upperBound - lowerBound)) + lowerBound);
    }

    private static int getRandomValue(int maxValue) {
        return (int) (Math.random() * maxValue);
    }


    static float[] introduceImpact(float[] group) {
        // Set random seed for reproducibility
        Random random = new Random(42);

        // Generate unique indices
        int[] indices = generateUniqueIndices(group.length, 2);

        // Introduce impact by adding 1 to the values at the selected indices
        for (int index : indices) {
            group[index] = (float) (group[index] * 1.1);
        }
        return group;
    }
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

    static int[] generateUniqueIndices(int maxIndex, int numIndices) {
        if (numIndices > maxIndex) {
            throw new IllegalArgumentException("Number of indices cannot be greater than the max index");
        }

        int[] indices = new int[numIndices];
        for (int i = 0; i < numIndices; i++) {
            indices[i] = i + new Random().nextInt(maxIndex - i);
        }

        return indices;
    }

    static float[] generateNormalDistribution(float mean, float stdDev, int size, Random random) {
        float[] values = new float[size];


        for (int i = 0; i < size; i++) {
            // Use Box-Muller transform to generate values from a normal distribution
            double u1 = random.nextDouble();
            double u2 = random.nextDouble();
            double z = Math.sqrt(-2.0 * Math.log(u1)) * Math.cos(2.0 * Math.PI * u2);

            // Scale and shift to achieve desired mean and standard deviation
            float generatedValue = (float) (mean + stdDev * z);

            values[i] = generatedValue;
        }

        return values;
    }



    public static float[] generateRandomConversionRates(int size){
        int [] userCounts = generateRandomUserCount(size);
        System.out.println("****************************************************************************\n\n\n");
        System.out.println("User_Counts" + Arrays.toString(userCounts));
        int [] conversionCounts = generateRandomConversions(userCounts);
        System.out.println("****************************************************************************\n\n\n");
        System.out.println("Conversion_counts" + Arrays.toString(conversionCounts));
        float[] randomConversionRate = new float[size];
        for (int i = 0; i < size; i++) {
            randomConversionRate[i] = (float) conversionCounts[i] / userCounts[i];
        }
        return randomConversionRate;
    }
}