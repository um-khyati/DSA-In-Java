class Solution {
    public int fillCups(int[] amount) {
        int cnt=amount[0]+amount[1]+amount[2];
        int mx=Math.max(amount[0],Math.max(amount[1],amount[2]));
        return Math.max(mx,(cnt+1)/2);
    }
}