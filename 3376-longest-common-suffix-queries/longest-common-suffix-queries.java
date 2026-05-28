class Solution {
    class TrieNode {
        TrieNode[] child=new TrieNode[26];
        int idx;
        int len;
        TrieNode() {
            idx = -1;
            len = Integer.MAX_VALUE;
        }
    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        TrieNode root = new TrieNode();
        for (int i = 0; i < wordsContainer.length; i++) {
            insert(root, wordsContainer[i], i);
        }
        int[] ans = new int[wordsQuery.length];
        for (int i = 0; i < wordsQuery.length; i++) {
            ans[i] = search(root, wordsQuery[i]);
        }
        return ans;
    }
    private void insert(TrieNode root, String word, int index) {
        TrieNode curr = root;
        update(curr, word.length(), index);
        for (int i = word.length() - 1; i >= 0; i--) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                curr.child[idx] = new TrieNode();
            }
            curr = curr.child[idx];
            update(curr, word.length(), index);
        }
    }
    private void update(TrieNode node, int len, int idx) {
        if (len < node.len) {
            node.len = len;
            node.idx = idx;
        }
    }
     private int search(TrieNode root, String word) {
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null) {
                break;
            }
            curr = curr.child[idx];
        }
        return curr.idx;
    }
}