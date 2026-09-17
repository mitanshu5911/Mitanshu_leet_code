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
    HashMap<TreeNode,TreeNode> parentmpp = new HashMap<>();
    public void buildParentMap(TreeNode root, TreeNode parent){
        if(root == null) return;

        parentmpp.put(root,parent);
        buildParentMap(root.left,root);
        buildParentMap(root.right,root);
    }
    TreeNode findNode(TreeNode root, int start){
        if(root == null) return null;
        if(root.val == start) return root;

        TreeNode leftAns = findNode(root.left,start);
        TreeNode rightAns = findNode(root.right,start);

        if(leftAns != null) return leftAns;
        return rightAns;
    }
    public int amountOfTime(TreeNode root, int start) {
        buildParentMap(root,null);
        TreeNode targetNode = findNode(root,start);

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode,Boolean> vis = new HashMap<>();

        int level = 0;

        q.offer(targetNode);
        vis.put(targetNode,true);
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();

                if(temp.left!= null && vis.get(temp.left)==null){
                    q.offer(temp.left);
                    vis.put(temp.left,true);
                }

                if(temp.right!=null && vis.get(temp.right) == null){
                    q.offer(temp.right);
                    vis.put(temp.right,true);
                }

                if(parentmpp.get(temp)!=null && vis.get(parentmpp.get(temp))==null){
                    q.offer(parentmpp.get(temp));
                    vis.put(parentmpp.get(temp),true);
                }
            }
            level++;
        }

        return level-1;

    }
}