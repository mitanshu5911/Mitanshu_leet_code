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
    void solve(TreeNode root, int[] arr, int low, int high){
        if(root == null) return; 

        solve(root.left, arr, low, high);

            if(root.val >= low && root.val <= high){
                arr[0] += root.val;
            }

        solve(root.right, arr, low, high);
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        int[] arr = new int[1];
        solve(root,arr,low,high);

        return arr[0];
    }
}