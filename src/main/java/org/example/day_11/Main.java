package org.example.day_11;

public class Main {
    public static void main(String[] args) {
        //each energy cell +1
        //if 9 + 1 all neighbours of this cell gets +1
        //check borders xBorder = <0,9> and yBorder = <0,9>
        //check neighbours oct[x][y]: top - oct[x][y-1], bottom - oct[x][y+1], left - oct[x-1][y], right - oct[x+1][y],
        // topLeft - oct[x-1][y-1], topRight - oct[x+1][y-1], botLeft - oct[x-1][y+1], botRight - oct[x+1][y+1]
    }
}

