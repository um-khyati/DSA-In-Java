class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, j = n - 2;

        for (int i = 0; i < 2; i++, j--) {
            while (j >= 0 && nums[j] == nums[j + 1])
                j--;
        }

        j++;

        if (j < 0)
            return nums[n - 1];

        return nums[j];
    }
}