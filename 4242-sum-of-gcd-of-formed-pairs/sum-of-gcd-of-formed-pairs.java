class Solution{
    public int gcd(int a, int b){
        if( b == 0 ) return a;
        return gcd(b, a%b);
    }

    public long gcdSum( int[] nums ){
        int n = nums.length;
        int prefixGcd[] = new int[n];
        int max = nums[0];

        for ( int i = 0; i < n; i++){
            max = Math.max(max,nums[i]);
            prefixGcd[i] = gcd(nums[i],max);
        }
    
    Arrays.sort(prefixGcd);

    long sum = 0;
    int i = 0, j = n-1;
    while (i<j){
        sum += (long) gcd (prefixGcd[i],prefixGcd[j]);
        i++;
        j--;
    }
    return sum;
}
}
