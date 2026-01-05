// LeetCode 1975: Maximum Matrix Sum
// Approach: Sum absolute values and adjust by the smallest absolute value if negatives count is odd.
// Time Complexity: O(n^2)
// Space Complexity: O(1)

class Solution {

    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long totalSum = 0;
        int negativeCount = 0;
        int minAbsValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int value = matrix[i][j];
                totalSum += Math.abs(value);

                if (value < 0) {
                    negativeCount++;
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(value));
            }
        }

        if (negativeCount % 2 == 0) {
            return totalSum;
        } else {
            return totalSum - 2 * minAbsValue;
        }
    }
}
