class Solution {

    void solve(TreeNode root, int[] arr){
        if(root == null) return;

        solve(root.left, arr);

        arr[0]--;
        if(arr[0]==0){
            arr[1] = root.val;
        }

        solve(root.right, arr);


    }
    public int kthSmallest(TreeNode root, int k) {
       int[] arr = new int[2];
        arr[0] = k;
        arr[1] = -1;
       solve(root, arr);
        return arr[1];
    }
};