// LeetCode 485: Max Consecutive Ones
// Approach: Traverse the array and count consecutive ones while tracking the maximum.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public int findMaxConsecutiveOnes(int[] nums) {
        int max_count = 0;
        int curr_count = 0;

        for (int num : nums) {
            if (num == 1) {
                curr_count++;
                max_count = Math.max(max_count, curr_count);
            } else {
                curr_count = 0;
            }
        }
        return max_count;
    }
}
