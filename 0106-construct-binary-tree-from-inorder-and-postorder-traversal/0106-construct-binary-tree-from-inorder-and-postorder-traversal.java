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
    HashMap<Integer,Integer> mpp = new HashMap<>();
    int n;
    int index;

    public TreeNode solve(int[] in, int[] post, int start, int end){
        if(index < 0 || start>end){
            return null;
        }

        int element = post[index--];
        TreeNode root = new TreeNode(element);
        int pos = mpp.get(element);

        root.right = solve(in,post,pos+1,end);
        root.left = solve(in,post,start,pos-1);

        return root;
    }

    public TreeNode buildTree(int[] in, int[] post) {
        n=in.length;
        index = n-1;
        for(int i=0; i<n; i++){
            mpp.put(in[i],i);
        }

        TreeNode root = solve(in, post, 0, n-1);
        return root;


    }
}