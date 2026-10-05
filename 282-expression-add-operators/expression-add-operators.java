class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;

        char[] path = new char[num.length() * 2];
        
        backtrack(result, path, num, target, 0, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, char[] path, String num, 
                           int target, int index, int len, long evalValue, long prevValue) {

        if (index == num.length()) {
            if (evalValue == target) {
                result.add(new String(path, 0, len));
            }
            return;
        }

        long curr = 0;
        int signIndex = len; 
        if (index != 0) {
            len++;
        }

        for (int i = index; i < num.length(); i++) {
            if (i != index && num.charAt(index) == '0') break;

            curr = curr * 10 + (num.charAt(i) - '0');
            
            path[len++] = num.charAt(i);

            if (index == 0) {
                backtrack(result, path, num, target, i + 1, len, curr, curr);
            } else {
                path[signIndex] = '+';
                backtrack(result, path, num, target, i + 1, len, evalValue + curr, curr);

                path[signIndex] = '-';
                backtrack(result, path, num, target, i + 1, len, evalValue - curr, -curr);

                path[signIndex] = '*';
                backtrack(result, path, num, target, i + 1, len, 
                          evalValue - prevValue + (prevValue * curr), prevValue * curr);
            }
        }
    }
}