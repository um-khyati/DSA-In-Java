class Solution {
    public boolean isPalindrome(String s) {
        String str=s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c: str.toCharArray())
        {
            if(Character.isLetterOrDigit(c))
            sb.append(c);

        }
        String strs = sb.toString();
        
        int i=0;
        int j=strs.length()-1;

        while(i<strs.length() && j>=0)
        {
            if(strs.length()%2==0)
            {
                if(strs.charAt(i)==strs.charAt(j))
                {
                    i++;
                    j--;

                    if(i>j)
                    return true;

                }

                else
                return false;
            }

            else
            {
                if(strs.charAt(i)==strs.charAt(j))
                {
                    i++;
                    j--;

                    if(i==j)
                    return true;
                }

                else
                return false;
            }
        }
        return true;
       
    }
}