class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[] arr = new int[n];

        for(int i=n-1;i>=0;i--){
            int diagonal = 0;
            arr[i] = 1;

            for(int j=i+1;j<n;j++){
                int temp = arr[j];

                if(s.charAt(i) == s.charAt(j)){
                    arr[j] = 2 + diagonal;
                }else{
                    arr[j] = Math.max(arr[j], arr[j-1]);
                }

                diagonal = temp;
            }
        }

        return arr[n-1];
    }
}