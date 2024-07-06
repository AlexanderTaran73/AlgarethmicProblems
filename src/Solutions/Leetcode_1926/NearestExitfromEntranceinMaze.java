package Solutions.Leetcode_1926;
import java.util.*;

/*
You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.
 */

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int columns = maze[0].length;
        Queue<int[]> states = new ArrayDeque<>();
        states.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] steps = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int counter = 0;
        int cordI;
        int cordJ;
        while (!states.isEmpty()){
            counter++;
            int n = states.size();
            for (int i = 0; i < n; i++) {
                int[] state = states.poll();
                for (int j = 0; j < steps.length; j++) {
                    cordI = state[0] + steps[j][0];
                    cordJ = state[1] + steps[j][1];
                    if (cordI < 0 || cordI >= rows || cordJ < 0 || cordJ >= columns) continue;
                    if (maze[cordI][cordJ] == '.') {
                        if (cordI == 0 || cordI == rows - 1 || cordJ == 0 || cordJ == columns - 1) {
                            return counter;
                        }
                        maze[cordI][cordJ] = '+';
                        states.offer(new int[]{cordI, cordJ});
                    }
                }
            }
        }
        return -1;
    }
}
