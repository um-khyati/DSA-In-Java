class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;

        int[] frequencies = new int[n];
        for(int number: nums) {
            if (number < 1 || number > n) {
                return false;
            }
            frequencies[number - 1]++;
        } 
        for(int i = 0; i < n - 1; ++i) {
            if (frequencies[i] != 1) {
                return false;
            }
        }
        if (frequencies[n - 1] != 2) {
            return false;
        }
        return true;
    }
}