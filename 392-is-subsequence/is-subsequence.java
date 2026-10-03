class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0){
            return true;
        }
        int left = s.length() - 1;
        int right = t.length() - 1;
        while(left >= 0 && right >= 0){
            if(s.charAt(left) == t.charAt(right)){
                left--;
            }
            right--;
        }
        return left < 0;
    }
}