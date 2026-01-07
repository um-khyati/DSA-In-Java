// LeetCode 136: Single Number
// Approach: Use XOR to cancel out duplicate numbers and find the unique element.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public int singleNumber(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            count ^= nums[i];
        }
        return count;
    }
}
