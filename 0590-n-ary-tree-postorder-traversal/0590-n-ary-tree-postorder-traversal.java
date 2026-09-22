/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    List<Integer> result = new ArrayList<>();

    void dfs(Node root){
        if(root == null) return;

        List<Node> arr = root.children;
        int len = arr.size();

        for(int i= 0; i < len;i++ ){
            dfs(arr.get(i));
        }
        result.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        dfs(root);
        return result;
    }
}