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
    TreeNode solve(TreeNode curr, int val){
        if(curr == null)  {
            return new TreeNode(val);
        }

       if(val > curr.val) curr.right = solve(curr.right,val);
        if(val < curr.val) curr.left = solve(curr.left,val);

        return curr;
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode curr = root;

       TreeNode res =  solve(curr,val);

        return res;
    }
}