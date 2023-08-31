package org.example.day_7;

public class Main {
    public static void main(String[] args) {
        int alignPos = 3;

        int [] crabPos = {16,1,2,0,4,2,7,1,2,14};

        int neededFuel = 0;

        for(int i = 0; i < crabPos.length; i++){
            int fuel = crabPos[i] - alignPos;
            neededFuel += (fuel < 0) ? -fuel : fuel;
        }

        System.out.println("Needed fuel: " + neededFuel);
    }
}
