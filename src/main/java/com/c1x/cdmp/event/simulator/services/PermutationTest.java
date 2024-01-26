package com.c1x.cdmp.event.simulator.services;

import java.util.Arrays;
import java.util.Random;

import static com.c1x.cdmp.event.simulator.services.ConversionSimulatorService.random;

public class PermutationTest {

    public static boolean permutationTest(int groupSize) {
        double mean = 0.5; // Adjusted mean
        int size = 10;

        // Generate values from a normal distribution between 0 and 1
        float [] group_A = ConversionSimulatorService.generateNormalDistribution(50, 10, size, random);
        float [] group_B = ConversionSimulatorService.generateNormalDistribution(40, 10, size, random);
        int[] impactIndices = ConversionSimulatorService.generateUniqueIndices(10, 2);
        for (int index : impactIndices) {
            group_A[index] += 1;
        }
//        group_A = new float[]{39.89933636F, 36.03555108F, 57.42611779F, 46.36211239F, 56.46482966F, 48.69220834F,
//                53.65922829F, 64.08411301F, 59.04499743F, 53.00733362F};
//        double[] doubleArray = {41.01512351, 18.97896097, 54.57869915, 42.39016874, 30.583182,
//                39.94189673, 41.13583281, 38.46664451, 35.12158344, 34.4206513};
//
//        // Convert double array to float array
//        group_B = new float[doubleArray.length];
//        for (int i = 0; i < doubleArray.length; i++) {
//            group_B[i] = (float) doubleArray[i];
//        }
      float [] group_C = ConversionSimulatorService.generateRandomConversionRates((int) Math.floor((double) groupSize /2));
      float [] group_D = ConversionSimulatorService.generateRandomConversionRates((int) Math.floor((double) groupSize /2));
      float real_diff = calculateMean(group_A) - calculateMean(group_B) ;
      float[] simulatedGroup_A;
      float[] simulatedGroup_B;
      boolean has_impact;
      float [] audience = concatenateArrays(group_A, group_B);
      int nSimulations = 1000;
      float [] simulated_diffs = new float[1000];

      for (int i = 0; i < nSimulations; i++) {

          //Shuffle the combined array
          shuffleArray(audience, random);

          simulatedGroup_A = Arrays.copyOfRange(audience, 0, group_A.length);
          simulatedGroup_B = Arrays.copyOfRange(audience, group_A.length, audience.length);
//          System.out.println("************************************************\n "+i+" th Iteration");
//          System.out.println("Mean group A "+calculateMean(simulatedGroup_A));
//          System.out.println("Mean group B "+calculateMean(simulatedGroup_B));
//          System.out.println("Difference "+(calculateMean(simulatedGroup_B)-calculateMean(simulatedGroup_A)));
          simulated_diffs[i] = calculateMean(simulatedGroup_A) - calculateMean(simulatedGroup_B);
      }
      float[] range = getPercentiles(simulated_diffs);
      System.out.println("Difference" + Arrays.toString(range));

        System.out.println("Real*" + real_diff);
        System.out.println("Range[0]" + range[0] );
        System.out.println("Range[1]" + range[1] );
        if(real_diff > range[0] && real_diff < range[1]) {


         has_impact = true;
      }
      else {
          has_impact = false;
      }
      System.out.println("Group A" + Arrays.toString(group_A));
      System.out.println("****************************************************************************\n\n\n");
      System.out.println("Group B" + Arrays.toString(group_B));
      System.out.println("****************************************************************************\n\n\n");
      System.out.println("Simulated differences" + Arrays.toString(simulated_diffs));

      return has_impact;
    }

    public static float[] getPercentiles(float[] simulatedDifferences) {
        Arrays.sort(simulatedDifferences);
        int index975 = (int) Math.ceil(0.975 * simulatedDifferences.length);
        int index025 = (int) Math.ceil(0.025 * simulatedDifferences.length);
        return new float[]{simulatedDifferences[index025 - 1], simulatedDifferences[index975 - 1]};
    }

    private static float calculateMean(int [] array) {
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return (float) sum / array.length;
    }

    private static float calculateMean(float [] array) {
        float sum = 0;
        for (float value : array) {
            sum += value;
        }
        return (float) sum / array.length;
    }

    private static void shuffleArray(float[] array, Random random)
    {
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            float temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

    private static int[] concatenateArrays(int[] A , int[] B) {
        int[] result = new int[A.length + B.length];
        System.arraycopy(A, 0, result, 0, A.length);
        System.arraycopy(B, 0, result, A.length, B.length);
        return result;
    }

    private static float[] concatenateArrays(float[] A , float[] B) {
        float[] result = new float[A.length + B.length];
        System.arraycopy(A, 0, result, 0, A.length);
        System.arraycopy(B, 0, result, A.length, B.length);
        return result;
    }
    public static void main(String[] args)
    {
        System.out.println("hasTrue" + permutationTest(20));
    }
}