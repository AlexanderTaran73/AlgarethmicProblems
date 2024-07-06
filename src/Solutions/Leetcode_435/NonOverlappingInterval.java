package Solutions.Leetcode_435;

import java.util.Arrays;

/*
Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prev = 0;
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (intervals[prev][1] > intervals[i][0]){
                count++;
            }
            else prev = i;
        }
        return count;
    }
}