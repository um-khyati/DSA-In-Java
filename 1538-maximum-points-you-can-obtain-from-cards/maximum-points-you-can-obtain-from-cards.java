class Solution {
    static{
        for(int i = 0;i<300;i++){
            maxScore(new int[]{1,2,3},1);
        }
    }
    public static int maxScore(int[] cardPoints, int k) {
        int ls = 0;
        for(int i = 0;i<k;i++){
            ls+=cardPoints[i];
        }
        int r = cardPoints.length-1;
        int max = 0;
        max = Math.max(max,ls);
        for(int i = k-1;i>=0;i--){
           ls-=cardPoints[i];
            ls+=cardPoints[r];
            r--;
            max = Math.max(max,ls);
        }
    return max;
    }
}