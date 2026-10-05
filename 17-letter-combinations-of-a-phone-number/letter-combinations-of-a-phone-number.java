class Solution {
    private String[] digitToChar = {
        "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    private void dfs(String digits, int index, StringBuilder combination, List<String> result) {
        if(combination.length() == digits.length()) {
            result.add(combination.toString());
            return;
        }
        String current = digitToChar[digits.charAt(index) - '2'];
        for(int i=0; i<current.length(); i++) {
            combination.append(current.charAt(i));
            dfs(digits, index + 1, combination, result);
            combination.deleteCharAt(combination.length() - 1);
        }
        return;
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder combination = new StringBuilder();
        dfs(digits, 0, combination, result);
        return result;
    }
}