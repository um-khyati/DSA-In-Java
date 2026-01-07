// LeetCode 1339: Maximum Product of Splitted Binary Tree
// Approach: Compute total tree sum, then use DFS to find max product by splitting at each subtree.
// Time Complexity: O(n)
// Space Complexity: O(n)

class Solution {

    static final int MOD = 1_000_000_007;
    long totalSum = 0;
    long maxProduct = 0;

    // Compute total sum of the tree
    private long getTotalSum(TreeNode root) {
        if (root == null) return 0;
        return root.val + getTotalSum(root.left) + getTotalSum(root.right);
    }

    // Postorder DFS to compute subtree sums and max product
    private long dfs(TreeNode root) {
        if (root == null) return 0;

        long left = dfs(root.left);
        long right = dfs(root.right);
        long subSum = root.val + left + right;

        maxProduct = Math.max(maxProduct, subSum * (totalSum - subSum));
        return subSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        dfs(root);
        return (int) (maxProduct % MOD);
    }
}
