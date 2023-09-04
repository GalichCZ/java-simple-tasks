package org.example.day_11;

public class Main {
    public static void main(String[] args) {
        //each energy cell +1
        //if 9 + 1 all neighbours of this cell gets +1
        //check borders xBorder = <0,9> and yBorder = <0,9>
        //check neighbours oct[x][y]: top - oct[x][y-1], bottom - oct[x][y+1], left - oct[x-1][y], right - oct[x+1][y],
        // topLeft - oct[x-1][y-1], topRight - oct[x+1][y-1], botLeft - oct[x-1][y+1], botRight - oct[x+1][y+1]

        int steps = 100;
        int [][] dataArray = {
                {5,4,8,3,1,4,3,2,2,3},
                {2,7,4,5,8,5,4,7,1,1},
                {5,2,6,4,5,5,6,1,7,3},
                {6,1,4,1,3,3,6,1,4,6},
                {6,3,5,7,3,8,5,4,7,8},
                {4,1,6,7,5,2,4,6,4,5},
                {2,1,7,6,8,4,1,7,2,1},
                {6,8,8,2,8,8,1,1,3,4},
                {4,8,4,6,8,4,8,5,5,4},
                {5,2,8,3,7,5,1,5,2,6}
        };

        int flashes = 0;

        int rowLength = dataArray.length;
        int colLength = dataArray[0].length;

        for(int k = 0; k < steps; k++){
            for(int i = 0; i < colLength; i++){
                for(int j = 0; j < rowLength; j++){
                    if(dataArray[i][j] == 9){
                        dataArray[i][j] = 0;
                        if(i > 0){ //top
                            dataArray[i-1][j]++;
                        }
                        if(i < colLength - 1){ //bot
                            dataArray[i+1][j]++;
                        }
                        if(j > 0){ //left
                            dataArray[i][j-1]++;
                        }
                        if(j < rowLength - 1){ //right
                            dataArray[i][j+1]++;
                        }
                        if(i > 0 && j > 0){ //top-left
                            dataArray[i-1][j-1]++;
                        }
                        if(i < colLength - 1 && j < rowLength - 1){ //bot-right
                            dataArray[i+1][j+1]++;
                        }
                        if(i < colLength - 1 && j > 0){ //bot-left
                            dataArray[i+1][j-1]++;
                        }
                        if(i > 0 && j < rowLength - 1){ //top-right
                            dataArray[i-1][j+1]++;
                        }
                    } else {
                        dataArray[i][j]++;
                    }
                    if(dataArray[i][j] == 0){
                        flashes++;
                    }
                }
            }
        }

        System.out.println(flashes);
    }
}

