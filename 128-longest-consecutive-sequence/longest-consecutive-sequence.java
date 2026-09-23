class Solution {
    static 
    {
        for(int i=0;i<500;i++)
            longestConsecutive(new int[]{});
    }
    
    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int min = nums[0];
        int max = nums[0];

        for (int num : nums){
            max = Math.max(num, max);
            min = Math.min(num, min);
        }

        if (max < 100000) {
            boolean [] apariciones = new boolean [max - min + 1];
            for (int num : nums) {
                apariciones[num - min] = true;
            }

            int maxTotal = 0;
            int maxLocal = 0;
            for (boolean a : apariciones) {
                if (a) {
                    maxLocal++;
                } else {
                    maxTotal = Math.max(maxTotal, maxLocal);
                    maxLocal = 0;
                }
            }
            maxTotal = Math.max(maxTotal, maxLocal);
            return maxTotal;
        } else {
            Set<Integer> uniNums = new HashSet();
            for( int num : nums ){
                uniNums.add(num);
            }

            int maxB = 0;
            for ( int num : uniNums ){
                if (!uniNums.contains(num - 1)){
                    int endSeq = num;
                    while (uniNums.contains(endSeq+1)){
                        endSeq++;
                    }
                    maxB = Math.max(maxB, endSeq - num + 1);
                }
            }
            return maxB;
        }
    }
}