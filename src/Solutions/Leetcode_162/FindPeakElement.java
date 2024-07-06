package Solutions.Leetcode_162;
import static java.lang.Integer.max;
/*
A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 1;
        int end = nums.length - 2;
        int mid;
        if(nums.length == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length-1] > nums[nums.length-2]) return nums.length-1;
        while (start <= end){

            mid = (end+start)/2;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) return mid;
            if(nums[mid] < nums[mid+1]){
                start = mid+1;
            }
            else end = mid;
        }
        return -1;

    }
}
