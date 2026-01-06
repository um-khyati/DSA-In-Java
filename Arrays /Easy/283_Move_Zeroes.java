// LeetCode 283: Move Zeroes
// Approach: Shift non-zero elements forward while counting zeros and place zeros at the end.
// Time Complexity: O(n)
// Space Complexity: O(1)

class Solution {

    public void moveZeroes(int[] nums) {
        int grp_size = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                grp_size++;
            } else if (grp_size > 0) {
                int temp = nums[i];
                nums[i] = 0;
                nums[i - grp_size] = temp;
            }
        }
    }
}
