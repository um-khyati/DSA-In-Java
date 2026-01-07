// LeetCode 66: Plus One
// Approach: Traverse digits from right to left, handle carry, and create a new array if needed.
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {

    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
