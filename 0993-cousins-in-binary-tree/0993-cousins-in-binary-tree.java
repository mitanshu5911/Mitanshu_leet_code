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
class Pair {
    TreeNode root;
    TreeNode parent;

    Pair(TreeNode r, TreeNode p){
        root = r;
        parent = p;
    }
}
class Solution {    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root,null));

        while(!q.isEmpty()){
            int size = q.size();
            TreeNode xNode = null;
            TreeNode xParent = null;

            TreeNode yNode = null;
            TreeNode yParent = null;

            for(int i = 0; i< size; i++){
                Pair p= q.poll();
                TreeNode temp = p.root;
                TreeNode temp_parent = p.parent;

                if(temp.val == x){
                    xNode = temp;
                    xParent = temp_parent;
                }
                if(temp.val == y){
                    yNode = temp;
                    yParent = temp_parent;
                }
                
                if(temp.left != null){
                    q.offer(new Pair(temp.left,temp));
                }
                if(temp.right != null){
                    q.offer(new Pair(temp.right,temp));
                }

            }

            if(xNode != null && xNode.val == x && yNode!=null && yNode.val == y && xParent != yParent){
                return true;
            }

        }

        return false;
    }
}