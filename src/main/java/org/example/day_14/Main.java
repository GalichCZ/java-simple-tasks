package org.example.day_14;

import java.util.HashMap;
import java.util.Map;

public class Main {
    static class FrequentSymbol{
        private final int frequent;
        private final char symbol;

        public FrequentSymbol(int frequent, char symbol) {
            this.frequent = frequent;
            this.symbol = symbol;
        }

        public int getFrequent() {
            return frequent;
        }

        public char getSymbol() {
            return symbol;
        }
    }

    private static Map<String, String> getMap() {
        Map<String, String> rules = new HashMap<>();
        rules.put("CH", "B");
        rules.put("HH", "N");
        rules.put("CB", "H");
        rules.put("NH", "C");
        rules.put("HB", "C");
        rules.put("HC", "B");
        rules.put("HN", "C");
        rules.put("NN", "C");
        rules.put("BH", "H");
        rules.put("NC", "B");
        rules.put("NB", "B");
        rules.put("BN", "B");
        rules.put("BB", "N");
        rules.put("BC", "B");
        rules.put("CC", "N");
        rules.put("CN", "C");
        return rules;
    }

    private FrequentSymbol findLargest(int nCount, int cCount, int bCount, int hCount){
        int largest = Integer.MIN_VALUE;
        char symbol = ' ';

        if (nCount > largest) {
            largest = nCount;
            symbol = 'N';
        }
        if (cCount > largest) {
            largest = cCount;
            symbol = 'C';
        }
        if (bCount > largest) {
            largest = bCount;
            symbol = 'B';
        }
        if (hCount > largest) {
            largest = hCount;
            symbol = 'H';
        }

        return new FrequentSymbol(largest, symbol);
    }

    private FrequentSymbol findSmallest(int nCount, int cCount, int bCount, int hCount){
        int smallest = Integer.MAX_VALUE;
        char symbol = ' ';

        if (nCount < smallest) {
            smallest = nCount;
            symbol = 'N';
        }
        if (cCount < smallest) {
            smallest = cCount;
            symbol = 'C';
        }
        if (bCount < smallest) {
            smallest = bCount;
            symbol = 'B';
        }
        if (hCount < smallest) {
            smallest = hCount;
            symbol = 'H';
        }

        return new FrequentSymbol(smallest, symbol);
    }

    public static void main(String[] args) {
        Map<String, String> rules = getMap();

        int steps = 10;

        String initialPolymer = "NNCB";

        StringBuilder newPolymerBuilder = new StringBuilder();

        String newPolymer = "";

        for(int j = 0; j < steps; j++) {
            while (initialPolymer.length() != 1) {
                char fChar = initialPolymer.charAt(0);
                char sChar = initialPolymer.charAt(1);
                String pair = String.valueOf(fChar) + sChar;
                String newPolymerElement = rules.get(pair);
                newPolymerBuilder.append(fChar).append(newPolymerElement);
                initialPolymer = initialPolymer.substring(1);
            }

            newPolymerBuilder.append(initialPolymer.charAt(0));
            initialPolymer = newPolymerBuilder.toString();
            newPolymer = newPolymerBuilder.toString();
            newPolymerBuilder.setLength(0);
        }

        int nCount = 0;
        int cCount = 0;
        int bCount = 0;
        int hCount = 0;

        for(int i = 0; i < newPolymer.length(); i++){
            char currentChar = newPolymer.charAt(i);
            if(currentChar == 'N'){
                nCount ++;
            }
            if(currentChar == 'C'){
                cCount ++;
            }
            if(currentChar == 'B'){
                bCount ++;
            }
            if(currentChar == 'H'){
                hCount ++;
            }
        }

        Main mainClass = new Main();

        FrequentSymbol smallest = mainClass.findSmallest(nCount,cCount,bCount,hCount);
        FrequentSymbol largest = mainClass.findLargest(nCount,cCount,bCount,hCount);

        System.out.printf("The most common element is: %s\nThe least common element is: %s\nDifference between %s and %s is: %s",
                largest.getSymbol(), smallest.getSymbol(), largest.getSymbol(), smallest.getSymbol(), largest.getFrequent() - smallest.getFrequent());
    }
}
