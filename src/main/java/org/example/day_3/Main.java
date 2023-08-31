package org.example.day_3;
public class Main {
    public static void main(String[] args){
        int[][] dataArray = {
                {0, 0, 1, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 1, 1, 0},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 1, 1, 1},
                {0, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 0},
                {0, 1, 0, 1, 0}
        };

        int numRows = dataArray.length;
        int numCols = dataArray[0].length;

        StringBuilder most = new StringBuilder();
        StringBuilder less = new StringBuilder();

        int one = 0;
        int zero = 0;
        for (int col = 0; col < numCols; col++) {
            for (int row = 0; row < numRows; row++) {
                if(dataArray[row][col] == 1){
                    one++;
                }else{
                    zero++;
                }
            }
            if(one > zero){
                most.append(1);
                less.append(0);
            }
            else {
                most.append(0);
                less.append(1);
            }
            one = 0;
            zero = 0;
        }

        int gamma = Integer.parseInt(most.toString(),2);
        int epsilon = Integer.parseInt(less.toString(),2);
        System.out.printf("power consumption of the submarine is %s", gamma*epsilon);
    }
}
