class Solution {

    int prev = -1;
    int diff = Integer.MAX_VALUE;

    void solve(TreeNode root) {

        if (root == null) {
            return;
        }

        solve(root.left);

        if (prev != -1) {
            diff = Math.min(diff, root.val - prev);
        }

        prev = root.val;

        solve(root.right);
    }

    public int minDiffInBST(TreeNode root) {

        solve(root);

        return diff;
    }
}