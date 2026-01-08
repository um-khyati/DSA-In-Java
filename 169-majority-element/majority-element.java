class Solution {
    public int majorityElement(int[] nums) {
        int count=0;
        int major_ele=0;

        for ( int num:nums ){
            if ( count == 0 ){
                major_ele = num;
            }
            if ( num == major_ele ){
                count++;
            }
            else{ count--; }
        }

       return major_ele; 
    }
}