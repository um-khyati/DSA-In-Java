class Solution {

    Set<String> st;
    Boolean[] dp;

    public boolean solve(int idx, String s) {
        if (idx == s.length()) return true;

        if (dp[idx] != null) return dp[idx];

        for (String word : st) {
            int len = word.length();
            if (idx + len <= s.length() &&
                s.substring(idx, idx + len).equals(word)) {

                if (solve(idx + len, s)) {
                    return dp[idx] = true;
                }
            }
        }
        return dp[idx] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        st = new HashSet<>();
        for (String word : wordDict) {
            st.add(word);
        }

        dp = new Boolean[s.length()];
        return solve(0, s);
    }
}