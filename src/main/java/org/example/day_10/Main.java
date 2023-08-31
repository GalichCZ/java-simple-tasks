package org.example.day_10;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //take array of chars and run through it from both sides
        Map<Character, Character> openClose = new HashMap<>();
        openClose.put('(', ')');
        openClose.put('[', ']');
        openClose.put('{', '}');
        openClose.put('<', '>');
    }
}
