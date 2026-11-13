class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        long[] val = new long[n];
        int[] cnt = new int[n];
        int head = n, tail = n - 1; 
        long cost = 0, ans = 0;
        int r = n - 1;
        for (int l = n - 1; l >= 0; l--) {
            int c = 1;
            while (head <= tail && val[head] <= nums[l]) {
                cost += (nums[l] - val[head]) * (long) cnt[head];
                c += cnt[head];
                head++;
            }
            head--;
            val[head] = nums[l]; cnt[head] = c;
            while (cost > k) {
                cost -= val[tail] - nums[r];
                if (--cnt[tail] == 0) tail--;
                r--;
            }
            ans += r - l + 1;
        }
        return ans;
    }
}