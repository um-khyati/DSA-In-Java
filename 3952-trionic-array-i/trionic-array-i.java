class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int peak = n - 1, valley = 0;

        for ( int i = 0; i < n - 1; i++){
            if(peak == n - 1 && nums[i]>= nums[i+1]){
                peak = i;
            }
            if(valley == 0 && nums[ n - 1 - i]<=nums[n - 2 - i]){
                valley = n - 1 - i;
            }
            if ( peak < valley )
            return isDec(nums , peak , valley);
        }
        return false;
    }
    public boolean isDec( int[] a,int b, int c){
        if(b==0 || c== a.length - 1) return false;
        for(int i = b; i < c; i++)
            if(a[i]<=a[i+1]) return false;
            return true;
    }
}