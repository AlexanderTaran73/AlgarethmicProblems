package Solutions.Leetcode_547;

/*
There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.
 */

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int counter = 0;
        int length = isConnected.length;
        boolean[] visited = new boolean[length];

        for (int i = 0; i < length; i++){
            if (!visited[i]){
                counter++;
                getCurcle(i, isConnected, visited);
            }
        }
        return counter;
    }

    public static void getCurcle(int m, int[][] isConnected, boolean[] visited){
        visited[m] = true;

        for (int i = 0; i < isConnected.length; i++){
            if (isConnected[m][i] == 1 && !visited[i]){
                getCurcle(i, isConnected, visited);
            }
        }

    }
}