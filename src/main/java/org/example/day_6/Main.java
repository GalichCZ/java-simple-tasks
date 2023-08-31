package org.example.day_6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int simulationDays = 80;
        ArrayList<Integer> fishes = new ArrayList<>();
        fishes.add(3);
        fishes.add(4);
        fishes.add(3);
        fishes.add(1);
        fishes.add(2);

        for(int i = 0; i < simulationDays; i++){
            int newFishes = 0;
            for(int j = 0; j < fishes.size(); j++){
                int nowFish = fishes.get(j);
                if(nowFish > 0) {
                    fishes.set(j, nowFish - 1);
                }
                else {
                    fishes.set(j, 6);
                    newFishes ++;
                }
            }
            for (int k = 0; k < newFishes; k++) {
                fishes.add(8);
            }
        }

        System.out.printf("Fish population: " + fishes.size());
    }
}
