class Solution {
    public int minPairSum(int[] nums) {
        int length = nums.length;
        int maxNum = nums[0];
        for(int n : nums){
            maxNum = Math.max(n, maxNum);
        }
        int[] table = new int[maxNum + 1];
        for(int n : nums){
            table[n]++;
        }
        int i = 1, j = maxNum, res = 0;
        while(i <= j){
            if(table[i] == 0){
                i++;
            }else if(table[j] == 0){
                j--;
            }else{
                int a = i;
                int b = j;
                res = Math.max(res, a + b);
                table[i]--;
                table[j]--;
            }
        }
        return res;
    }
}