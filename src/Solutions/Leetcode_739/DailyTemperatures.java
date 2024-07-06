package Solutions.Leetcode_739;

import java.util.ArrayDeque;
import java.util.Deque;
/*
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int start = 0;

        for (int i = 0; i < temperatures.length; i++) {
            while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]){
                temperatures[deque.peekLast()] = i-deque.peekLast();
                start++;
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        while (!deque.isEmpty()){
            temperatures[deque.pollLast()] = 0;
        }
        return temperatures;
    }
}