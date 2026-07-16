class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int mx = 0;
        int[] prefixGcd = new int[n];
        for(int i=0;i<n;i++) {
            int num = nums[i];
            mx = Math.max(mx, num);
            prefixGcd[i] = gcd(mx, num);
        }

        Arrays.sort(prefixGcd);

        int i=0, j=n-1;
        long sum = 0;
        while(i < j) {
            sum += gcd(prefixGcd[i], prefixGcd[j]);
            i++;
            j--;
        }

        return sum;
    }

    private int gcd(int a, int b) {
        while(b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}