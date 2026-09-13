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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return ans;

        q.offer(root);
        boolean isLeft = true;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> arr = new ArrayList<>();

            for(int i=0; i<size;i++){
                TreeNode temp = q.poll();
                arr.add(temp.val);

                if(temp.left!=null) q.offer(temp.left);
                if(temp.right!=null) q.offer(temp.right);

            }
            if(!isLeft){
                Collections.reverse(arr);
            }

            ans.add(arr);
            isLeft = !isLeft; 
        }
        return ans;
    }
}