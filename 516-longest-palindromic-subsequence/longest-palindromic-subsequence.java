class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] arr = s.toCharArray();
        int[][]dp = new int[arr.length][arr.length];
        for(int i=arr.length-1; i>=0; i--)
        {
            dp[i][i]=1;
            for(int j=i+1; j<arr.length; j++)
            {
                if(arr[i]==arr[j])
                {
                    dp[i][j]=dp[i+1][j-1]+2;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][arr.length-1];
    }
}