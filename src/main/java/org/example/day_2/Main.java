package org.example.day_2;

public class Main {
    public static void main(String[] args) {
        final String UP = "up";
        final String FORWARD = "forward";
        final String DOWN = "down";

        int horizontalPos = 0;
        int depthPos = 0;

        String [] movements = new String[]{ "forward 5", "down 5", "forward 8", "up 3", "down 8", "forward 2" };

        for(String movement : movements){
            int movementValue = Integer.parseInt(movement.substring(movement.length()-1));
            if(movement.contains(FORWARD)){
                horizontalPos += movementValue;
            }
            else if (movement.contains(DOWN)) {
                depthPos -= movementValue;
            }
            else {
                depthPos += movementValue;
            }
        }

        System.out.println(Math.abs(horizontalPos * depthPos));
    }
}
