class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int j = 0, ans = Integer.MAX_VALUE, min = nums[0], max = nums[0];
        for(int i = k-1; i< nums.length; i++){
            ans = Math.min(ans, nums[i]-nums[j]);
            j++;
        }
        return ans;
    }
}