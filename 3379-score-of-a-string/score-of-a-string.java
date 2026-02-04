class Solution {
    public int scoreOfString(String s) { 
        return sumscore(s,0);
    }

    int sumscore(String s, int indx) {
        if(indx == s.length() -1) {
            return 0;
        }
        int diff = Math.abs(s.charAt(indx + 1) - s.charAt(indx));
        return diff + sumscore(s, indx + 1);
    }
}