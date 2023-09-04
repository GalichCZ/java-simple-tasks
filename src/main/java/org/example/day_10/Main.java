package org.example.day_10;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        /*
         * FOR THE PERSON WHO WILL READ THIS CODE !
         * It is the almost same case as in day 15, I just want to find all solutions for all problems from this web,
         * so I leave it here
         */

        //take array of chars and run through it from both sides
        Map<Character, Character> openClose = new HashMap<>();
        openClose.put('(', ')');
        openClose.put('[', ']');
        openClose.put('{', '}');
        openClose.put('<', '>');
    }
}
