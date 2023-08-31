package org.example.day_4;

import java.util.*;

public class Main {

    static class Node {
        int x, y;
        int distance;

        Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    public static int findShortestPath(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Create a 2D array to track distances
        int[][] distances = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            Arrays.fill(distances[i], Integer.MAX_VALUE);
        }

        // Define the four possible movement directions (up, down, left, right)
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Create a priority queue for Dijkstra's algorithm
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.distance));

        // Start at the top-left corner
        pq.add(new Node(0, 0, grid[0][0]));
        distances[0][0] = grid[0][0];

        while (!pq.isEmpty()) {
            Node currentNode = pq.poll();
            int x = currentNode.x;
            int y = currentNode.y;
            int currentDistance = currentNode.distance;

            // If we reach the bottom-right corner, return the shortest distance
            if (x == rows - 1 && y == cols - 1) {
                return currentDistance;
            }

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // Check if the new position is within bounds
                if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                    int newDistance = currentDistance + grid[newX][newY];
                    System.out.println("grid: "+grid[newX][newY]);
                    if (newDistance < distances[newX][newY]) {
                        distances[newX][newY] = newDistance;
                        System.out.println(newDistance);
                        pq.add(new Node(newX, newY, newDistance));
                    }
                }
            }
        }

        // If there's no path to the bottom-right corner
        return -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 6, 3, 7, 5, 1, 7, 4, 2},
                {1, 3, 8, 1, 3, 7, 3, 6, 7, 2},
                {2, 1, 3, 6, 5, 1, 1, 3, 2, 8},
                {3, 6, 9, 4, 9, 3, 1, 5, 6, 9},
                {7, 4, 6, 3, 4, 1, 7, 1, 1, 1},
                {1, 3, 1, 9, 1, 2, 8, 1, 3, 7},
                {1, 3, 5, 9, 9, 1, 2, 4, 2, 1},
                {3, 1, 2, 5, 4, 2, 1, 6, 3, 9},
                {1, 2, 9, 3, 1, 3, 8, 5, 2, 1},
                {2, 3, 1, 1, 9, 4, 4, 5, 8, 1}
        };

        int shortestDistance = findShortestPath(grid);
        System.out.println("Shortest Distance: " + shortestDistance);
    }
}
