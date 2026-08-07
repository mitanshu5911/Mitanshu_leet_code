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
    vector<TreeNode*> result;
    unordered_map<int,bool> mpp;

    TreeNode* deleteHelper(TreeNode* root){
        if(root== NULL)
            return NULL;

            root->left = deleteHelper(root->left);
            root->right = deleteHelper(root->right);

            if(mpp[root->val]){
                if(root->left != NULL)
                    result.push_back(root->left);
                
                if(root->right != NULL)
                    result.push_back(root->right);
                
                return NULL;
            }else{
                return root;
            }


    }
    vector<TreeNode*> delNodes(TreeNode* root, vector<int>& to_delete) {


        for(int num:to_delete){
            mpp[num] = true;
        }

        deleteHelper(root);

        if(!mpp[root->val]){
            result.push_back(root);
        }
        return result;
    }
};