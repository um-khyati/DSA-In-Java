class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int count = 0;
        int lessthan = 0;

        for(int x : nums){
            if(x==target) count++;
            else if(x<target) lessthan++;
        }

        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i<count ; i++){
            ans.add(lessthan + i);
        }

        return ans ; 
    }
}