// LeetCode 14: Longest Common Prefix
// Approach: Sort the array and compare the first and last strings character by character.
// Time Complexity: O(n log n)
// Space Complexity: O(1)

import java.util.Arrays;

class Solution {

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);

        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int idx = 0;

        while (idx < s1.length() && idx < s2.length()) {
            if (s1.charAt(idx) == s2.charAt(idx)) {
                idx++;
            } else {
                break;
            }
        }
        return s1.substring(0, idx);
    }
}
