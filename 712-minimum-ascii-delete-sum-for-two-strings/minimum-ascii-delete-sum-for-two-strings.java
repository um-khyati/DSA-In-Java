class Solution {
    public int minimumDeleteSum(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        int[] dp = new int[n2 + 1];

        for (int j = 1; j <= n2; j++) {
            dp[j] = dp[j - 1] + s2.charAt(j - 1);
        }

        for (int i = 1; i <= n1; i++) {
            int prev = dp[0];
            dp[0] += s1.charAt(i - 1);

            for (int j = 1; j <= n2; j++) {
                int temp = dp[j];
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[j] = prev;
                } else {
                    dp[j] = Math.min(
                        dp[j] + s1.charAt(i - 1),
                        dp[j - 1] + s2.charAt(j - 1)
                    );
                }
                prev = temp;
            }
        }
        return dp[n2];
    }
}
