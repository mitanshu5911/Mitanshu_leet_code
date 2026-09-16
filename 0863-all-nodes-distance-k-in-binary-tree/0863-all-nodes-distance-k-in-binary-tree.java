/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode,TreeNode> mpp = new HashMap<>();
    void buildParent(TreeNode root, TreeNode parent){
        if(root == null) return;

        mpp.put(root,parent);

        buildParent(root.left,root);
        buildParent(root.right,root);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        buildParent(root,null);

        HashMap<TreeNode,Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        
        q.offer(target);
        vis.put(target,true);

        int curr_level = 0;

        while(!q.isEmpty()){
            int size = q.size();

            if(curr_level == k) break;
            curr_level++;

            for(int i = 0; i<size; i++){
                TreeNode temp = q.poll();
                if(temp.left != null && vis.get(temp.left) == null){
                    q.offer(temp.left);
                    vis.put(temp.left,true);
                }

                 if(temp.right != null && vis.get(temp.right) == null){
                    q.offer(temp.right);
                    vis.put(temp.right,true);
                }

                if(mpp.get(temp) != null && vis.get(mpp.get(temp)) == null){
                    q.offer(mpp.get(temp));
                    vis.put(mpp.get(temp),true);
                }


            }
        }

        List<Integer> result = new ArrayList<>();

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            result.add(curr.val);
        }
        return result;
    }
}