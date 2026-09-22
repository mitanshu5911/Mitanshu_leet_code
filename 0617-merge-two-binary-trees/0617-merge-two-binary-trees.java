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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null ) return null;
        // if(root1 == null && root2 != null) return root2;
        // if(root1 != null && root2 == null) return root1;

        int x = root1!=null?root1.val : 0;
        int y = root2!=null? root2.val : 0;

        TreeNode root = new TreeNode(x+y);

        root.left = mergeTrees(
            root1 != null ? root1.left : null,
            root2 != null ? root2.left : null
        );

        root.right = mergeTrees(
            root1 != null ? root1.right : null,
            root2 != null ? root2.right : null
        );

        return root;
    }
}