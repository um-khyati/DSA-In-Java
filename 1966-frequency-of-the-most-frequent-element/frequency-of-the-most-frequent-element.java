class Solution {
    public int maxFrequency(int[] nums, int k) {
        int max=0;
        int n=nums.length;
        for(int num:nums){
           max= Math.max(max,num);
        }
        int count[]=new int[max+1];
        for(int num:nums) count[num]++;
        int idx=0;
        for(int i=0;i<=max;i++){
            while(count[i]>0){
                nums[idx]=i;
                idx++;
                count[i]--;
            }
        }
        int l=0;
        long total=0;
        for(int r=0;r<n;r++){
            total+=nums[r];
           if((long)nums[r]*(r-l+1)-total>k){
            total-=nums[l];
            l++;
           }
        }
        return n-l;
    }

}