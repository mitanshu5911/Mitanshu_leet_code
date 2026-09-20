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
    void inorderTra(TreeNode root,List<Integer> inorder){
        if(root == null) return;

        inorderTra(root.left,inorder);
        inorder.add(root.val);
        inorderTra(root.right,inorder);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> inorder = new ArrayList<>();
        inorderTra(root,inorder);

        return inorder.get(k - 1);
    }
}