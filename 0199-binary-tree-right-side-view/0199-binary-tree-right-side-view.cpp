/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> rightSideView(TreeNode* root) {
        if(root == nullptr) return {};

        queue<pair<int,TreeNode*>> q;
        q.push({0,root});

        unordered_map<int,int> mpp;

        while(!q.empty()){
            auto temp = q.front();
           int level = temp.first;
           TreeNode* node = temp.second;
            q.pop();

            mpp[level] = node->val;

            if(node->left){
                q.push({level+1,node->left});
            }
            if(node->right){
                q.push({level+1,node->right});
            }  
        }
        int len = mpp.size();

        vector<int> ans(len);

        for(auto it:mpp){
            ans[it.first] = it.second;
        }
        return ans;
    }
};