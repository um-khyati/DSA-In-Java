class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n < 0) return false;
        int start = 0;
        int end = 30;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(Math.pow(2,mid) == n) return true;
            else if(Math.pow(2,mid) < n) start = mid+1;
            else end = mid - 1;
        }
        return false;
    }
}