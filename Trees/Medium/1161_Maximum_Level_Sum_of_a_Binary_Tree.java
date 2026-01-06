// LeetCode 1161: Maximum Level Sum of a Binary Tree
// Approach: Use level-order traversal (BFS) to compute the sum at each level and track the maximum.
// Time Complexity: O(n)
// Space Complexity: O(n)

import java.util.*;

class Solution {

    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int max_sum = Integer.MIN_VALUE;
        int max_lvl = 1;
        int curr_lvl = 1;

        while (!q.isEmpty()) {
            int lvl_size = q.size();
            int lvl_sum = 0;

            for (int i = 0; i < lvl_size; i++) {
                TreeNode node = q.poll();
                lvl_sum += node.val;

                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }

            if (lvl_sum > max_sum) {
                max_sum = lvl_sum;
                max_lvl = curr_lvl;
            }
            curr_lvl++;
        }
        return max_lvl;
    }
}
