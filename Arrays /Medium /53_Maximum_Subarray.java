// LeetCode 53: Maximum Subarray
// Approach: Use Kadane’s Algorithm to track current and maximum subarray sum.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public int maxSubArray(int[] nums) {
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            currsum += nums[i];

            if (currsum > maxsum) {
                maxsum = currsum;
            }

            if (currsum < 0) {
                currsum = 0;
            }
        }
        return maxsum;
    }
}
