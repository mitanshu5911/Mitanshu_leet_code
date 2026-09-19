class Solution {
    int ans = 0;

    int tiltTree(TreeNode root) {
        if(root == null)
            return 0;

        int leftSum = tiltTree(root.left);
        int rightSum = tiltTree(root.right);

        ans += Math.abs(leftSum - rightSum);

        return root.val + leftSum + rightSum;
    }

    public int findTilt(TreeNode root) {
        tiltTree(root);
        return ans;
    }
}