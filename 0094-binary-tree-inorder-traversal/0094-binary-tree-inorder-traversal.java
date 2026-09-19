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
    public TreeNode findPredecessor(TreeNode curr){
        TreeNode prev = curr.left;
        while(prev.right !=null && prev.right != curr){
            prev = prev.right;
        }
        return prev;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode curr = root;

        while(curr!=null){
            if(curr.left == null){
                ans.add(curr.val);
                curr = curr.right;
            }else{
                TreeNode pre = findPredecessor(curr);
                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                }else{
                    pre.right = null;
                    ans.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return ans;
    }
}