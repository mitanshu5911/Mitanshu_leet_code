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
    int n;
    int findPostion(int[] preorder, int ele, int s, int e){
        int index = e+1;
        for(int i = s; i<=e;i++){
            if(preorder[i]>ele){
                index = i;
                break;
            }
        }
        return index;
    }
    public TreeNode solve(int[] preorder, int start, int end){
        if(start>end) return null;

        int element = preorder[start];
        TreeNode root = new TreeNode(element);
        int pos = findPostion(preorder,element,start+1,end);

        root.left = solve(preorder,start+1, pos-1);
        root.right = solve(preorder,pos,end);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        n = preorder.length;
        int start = 0;
        int end = n - 1;

        return solve(preorder,start,end);
    }
}