// LeetCode 345: Reverse Vowels of a String
// Approach: Use two pointers to swap vowels from both ends of the string.
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {

    public String reverseVowels(String s) {
        char[] arr = s.toCharArray();
        int start = 0, end = s.length() - 1;

        while (start < end) {
            while (start < end && !isVowel(arr[start])) start++;
            while (start < end && !isVowel(arr[end])) end--;

            if (start < end) {
                char temp = arr[start];
                arr[start++] = arr[end];
                arr[end--] = temp;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
