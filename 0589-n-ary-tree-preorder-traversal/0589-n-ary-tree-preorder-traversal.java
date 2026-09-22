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
};
*/

class Solution {
    List<Integer> result = new ArrayList<>();
    void dfs(Node root){
        if(root == null) return;

        result.add(root.val);
        List<Node> arr = root.children;
        for(int i = 0; i< arr.size(); i++){
            dfs(arr.get(i));
        }
    }
    public List<Integer> preorder(Node root) {
        dfs(root);
        return result;
    }
}