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
class Tuple {
    TreeNode node;
    int row;
    int col;

    public Tuple(TreeNode n, int r, int c){
        node = n;
        row = r;
        col = c;
    }
}
class Solution {
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer,List<Integer>>> mpp = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<Tuple>();
        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!mpp.containsKey(x)){
                mpp.put(x,new TreeMap<>());
            }

            if(!mpp.get(x).containsKey(y)){
                mpp.get(x).put(y,new ArrayList<>());
            }

            mpp.get(x).get(y).add(node.val);
            Collections.sort(mpp.get(x).get(y));

            if(node.left!=null){
                q.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right!=null){
                q.offer(new Tuple(node.right,x+1,y+1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
       for(TreeMap<Integer,List<Integer>> ys : mpp.values()) {
    List<Integer> col = new ArrayList<>();

    for(List<Integer> nodes : ys.values()) {
        col.addAll(nodes);
    }

    list.add(col);
}

        return list;
        
    }
}