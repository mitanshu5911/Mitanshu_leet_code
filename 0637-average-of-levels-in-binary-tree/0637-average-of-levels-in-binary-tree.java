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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) {
            return res;
        }

        q.offer(root);

        while(!q.isEmpty()){
            int size = q.size();
            long sum = 0;

            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();
                sum += temp.val;

                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);
            }
            double x = (double) sum/size;
            res.add(x);
        }
        return res;
    }
}