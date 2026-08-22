class Solution {
    public boolean checkDivisibility(int n) {
        long sum = 0;
        long product = 1;
        int x = n;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            product *= digit;
            n /= 10;
        }

        long value = sum + product;

        return x % value == 0;
    }
}