/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static int height(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftAns = height(root.left);
        int rightAns = height(root.right);

        return 1+Math.max(leftAns,rightAns);
    }
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;

        boolean leftRes  = isBalanced(root.left);
        boolean rightRes = isBalanced(root.right);

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        boolean res = leftRes && rightRes && (Math.abs(leftHeight - rightHeight) <= 1);
        return res;
    }
}