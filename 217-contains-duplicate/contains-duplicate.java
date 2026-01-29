class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> mp=new HashSet<>();
        for(int i : nums){
            if(!mp.add(i)){
                return true;
            }
        }
        return false;
    }
}