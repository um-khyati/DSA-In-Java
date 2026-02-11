import java.util.Arrays;
class Solution {
    private long totalhrs(int[] piles, int speed) {
        long totalh = 0;
        for (int bananas : piles) {
            totalh += (bananas + speed - 1) / speed;
        }
        return totalh;
    }


    public int minEatingSpeed(int[] piles, int h) {
        int maxpile = 0;
        for (int p : piles) {
            maxpile = Math.max(maxpile, p);
}


        int low=1, high = maxpile;
        int ans = maxpile;
        while( low <= high ){
            int mid =( low+high)/2;
            long totalh = totalhrs(piles,mid);
            if ( totalh <= h ){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }
}