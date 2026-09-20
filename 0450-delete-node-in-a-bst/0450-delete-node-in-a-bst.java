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
    int minVal(TreeNode root){
        if(root == null) return 0;
        while(root.left!=null){
            root = root.left;
        }
        return root.val;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;

        if(root.val == key){
            //0 child
            if(root.left == null && root.right == null){
                root = null;
                return null;
            }
            //1 child

                // left child
                    if(root.left != null && root.right == null){
                        TreeNode temp = root.left;
                        root = null;
                        return temp;
                    }

                 // right child
                    if(root.left == null && root.right != null){
                        TreeNode temp = root.right;
                        root = null;
                        return temp;
                    }
                
            //2 child
            
            if(root.left != null && root.right != null){
                int mini = minVal(root.right);
                root.val = mini;

                root.right = deleteNode(root.right,mini);
                return root;
            }
        }
        else if (root.val > key){
            root.left = deleteNode(root.left,key);
        }else{
            root.right = deleteNode(root.right,key);
        }

        return root;
    }
}