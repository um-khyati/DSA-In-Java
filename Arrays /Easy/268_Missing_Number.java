// LeetCode 268: Missing Number
// Approach: Use sum formula n(n+1)/2 and subtract the array sum to find the missing number.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        int total_sum = n * (n + 1) / 2;
        return total_sum - sum;
    }
}
