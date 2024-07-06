package Solutions.Leetcode_198;

import static java.lang.Integer.max;

/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.
 */

class Solution {
    public int rob(int[] nums) {
        if (nums.length==1)return nums[0];
        if (nums.length > 2) nums[2] = nums[0]+nums[2];
        for (int i = 3; i < nums.length; i++) {
            nums[i] = max(nums[i-2], nums[i-3])+nums[i];
        }
        return max(nums[nums.length-1], nums[nums.length-2]);

    }
}