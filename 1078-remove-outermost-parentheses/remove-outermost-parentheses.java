class Solution {
    public String removeOuterParentheses(String s) {
        int sum = 0, st = 0, end = 0;
        StringBuilder res = new StringBuilder();

        while (end < s.length()) {
            if (s.charAt(end) == '(') sum++;
            else sum--;

            if (sum == 0) {
                res.append(s.substring(st + 1, end));
                st = end + 1;
            }
            end++;
        }
        return res.toString();
    }
}