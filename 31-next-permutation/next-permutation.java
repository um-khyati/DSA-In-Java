class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int pivot = n - 2;
        while (pivot >= 0 && nums[pivot] >= nums[pivot + 1]) {
            pivot--;
        }
        if (pivot < 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        int j = n - 1;
        while (nums[j] <= nums[pivot]) {
            j--;
        }
        int temp = nums[pivot];
        nums[pivot] = nums[j];
        nums[j] = temp;

        reverse(nums, pivot + 1, n - 1);
    }
    private void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
