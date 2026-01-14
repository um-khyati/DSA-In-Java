class Solution {
    public int reverse(int x) {
        long y = 0;
        boolean isNegative = false;
        if(x<0){
            x = x*-1;
            isNegative = true;
        }
        while(x > 0){
            y = y*10 + x%10;
            if (y < Integer.MIN_VALUE || y > Integer.MAX_VALUE)
                return 0;
            x = x/10;
        }
        if(isNegative)
            return (int)(-y);
        return (int)y;
    }
}