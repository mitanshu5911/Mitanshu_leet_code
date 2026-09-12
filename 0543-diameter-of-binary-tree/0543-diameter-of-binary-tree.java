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
    static int[] treeDiameter(TreeNode root){
        int[] arr = new int[2];
        if(root == null) {
            arr[0]=0;arr[1]=0;
            return arr;
        }

        int []leftRes = treeDiameter(root.left);
        int []rightRes = treeDiameter(root.right);

        int op1 = leftRes[0];
        int op2 = rightRes[0];

        int op3  = leftRes[1] + rightRes[1] + 1;

        arr[0] = Math.max(op1,Math.max(op2,op3));

        arr[1] = Math.max(leftRes[1],rightRes[1]) + 1;

        return arr;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return treeDiameter(root)[0] - 1;
    }
}