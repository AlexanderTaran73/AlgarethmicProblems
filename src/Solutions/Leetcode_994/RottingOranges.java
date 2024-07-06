package Solutions.Leetcode_994;

import java.util.ArrayDeque;
import java.util.Queue;
/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */
class Solution {
    public int orangesRotting(int[][] grid) {
        int counter = 0, m = grid.length, n = grid[0].length, time = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) counter++;
                else if (grid[i][j] == 2) queue.add(new int[]{i, j});
            }
        }
        int k;
        while (!queue.isEmpty()){
            k = queue.size();
            time++;
            for (int i = 0; i < k; i++) {
                int[] data = queue.poll();

                for (int j = 0; j < steps.length; j++) {
                    int x = data[0] + steps[j][0];
                    int y = data[1] + steps[j][1];

                    if (x>=0 && y>=0 && x<m && y<n){
                        if (grid[x][y] == 1){
                            grid[x][y] = 2;
                            queue.add(new int[]{x, y});
                            counter--;
                        }
                    }
                }

            }
        }
        return counter == 0 ? Math.max(time - 1, 0) : -1;
    }
}