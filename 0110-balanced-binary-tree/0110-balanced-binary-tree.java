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
    int[] checkBalancedTree(TreeNode root){
        int[] arr = new int[2];
        if(root == null){
            arr[0] = 1;
            arr[1] = 0;

            return arr;
        }

        int []left = checkBalancedTree(root.left);
        int []right = checkBalancedTree(root.right);

        boolean leftAns = left[0] != 0;
        boolean rightAns = right[0] !=0 ;

        boolean diff = Math.abs(left[1]-right[1]) <= 1;

        arr[1] = Math.max(left[1],right[1])+1;

        arr[0] = (leftAns && rightAns && diff) ? 1 : 0 ;

        return arr;
    }
    public boolean isBalanced(TreeNode root) {
        return checkBalancedTree(root)[0] != 0 ? true : false ;
    }
}