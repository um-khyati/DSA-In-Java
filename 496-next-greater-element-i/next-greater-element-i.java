class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        int j = 0;
        for(int num : nums1){
            int max = -1;
            int i = 0;
            while(nums2[i++] != num);
            while(i < nums2.length && nums2[i] <= num){
                i++;
            }
            max = (i == nums2.length) ? -1 : nums2[i];
            result[j++] = max;
        }
        return result;
    }
}