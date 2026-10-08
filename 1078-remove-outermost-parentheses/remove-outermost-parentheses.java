class Solution {
    public String removeOuterParentheses(String s) {
        char[] result = new char[s.length()];
        int index = 0;
        int opened = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (opened > 0) {
                    result[index++] = c;
                }
                opened++;
            } else {
                opened--;
                if (opened > 0) {
                    result[index++] = c;
                }
            }
        }

        return new String(result, 0, index);
    }
}