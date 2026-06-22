class Solution {
    public int rearrangeCharacters(String s, String target) {
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> ft = new HashMap<>();

        for (char ch : target.toCharArray()) {
            ft.put(ch, ft.getOrDefault(ch, 0) + 1);
        }

        for (char ch : s.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        int answer = Integer.MAX_VALUE;

        for (char ch : target.toCharArray()) {
            if (!freq.containsKey(ch)) {
                return 0;
            }

            answer = Math.min(answer, freq.get(ch) / ft.get(ch));
        }

        return answer;
    }
}