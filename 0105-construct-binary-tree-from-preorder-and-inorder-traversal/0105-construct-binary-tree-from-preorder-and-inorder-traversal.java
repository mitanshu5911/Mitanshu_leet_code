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
    int index = 0;

    int findPosition(int[] in, int element){
        for(int i=0; i<n; i++){
            if(in[i] == element)return i;
        }
        return -1;
    }
    public TreeNode solve(int[] in, int[] pre, int start,int end){
        if(index >= n || start>end) return null;
        
        int element = pre[index++];

        TreeNode root = new TreeNode(element);

        int position = findPosition(in,element);

        root.left = solve(in,pre,start,position-1);
        root.right = solve(in,pre,position+1,end);

        return root;
    }

    public TreeNode buildTree(int[] pre, int[] in) {
         n=in.length;
        return solve(in,pre, 0,n-1);
    }
}