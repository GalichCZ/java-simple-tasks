package org.example.day_1;

public class Main {
    public static void main(String[] args) {
        int[] measurements = new int[]{199, 200, 208, 210, 200, 207, 240, 269, 260, 263};

        int increasedCount = 0;
        for(int i = 0; i < measurements.length - 1; i++){
            if(measurements[i] < measurements[i+1]){
                increasedCount++;
            }
        }

        System.out.printf("In this example, there are %s measurements that are larger than the previous measurement.", increasedCount);
    }
}