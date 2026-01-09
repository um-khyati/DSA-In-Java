class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder("");
        int rightPointer = -1;
        int leftPointer = -1;
        
        // Iterate backwards through the string
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                // If we encounter a space and we were tracking a word
                if (rightPointer != -1 && leftPointer != -1) {
                    // Add space before the word if it's not the first word added
                    if (ans.length() > 0) ans.append(" ");
                    ans.append(s.substring(leftPointer, rightPointer + 1));
                    
                    // Reset pointers
                    leftPointer = -1;
                    rightPointer = -1;
                }
                continue;
            }
            
            // If it's a character, update pointers
            if (rightPointer == -1) rightPointer = i; // Mark end of word
            if (rightPointer != -1) leftPointer = i;  // Mark start of word (keeps moving left)
        }
        
        // Append the last word (which corresponds to the first word in original string)
        if (rightPointer != -1 && leftPointer != -1) {
            if (ans.length() > 0) ans.append(" ");
            ans.append(s.substring(leftPointer, rightPointer + 1));
        }
        
        return ans.toString();
    }
}