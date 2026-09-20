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
    
    public TreeNode insertIntoBST(TreeNode curr, int val) {
        if(curr == null)  {
            return new TreeNode(val);
        }

       if(val > curr.val) curr.right = insertIntoBST(curr.right,val);
       if(val < curr.val) curr.left = insertIntoBST(curr.left,val);

        return curr;
    }
}