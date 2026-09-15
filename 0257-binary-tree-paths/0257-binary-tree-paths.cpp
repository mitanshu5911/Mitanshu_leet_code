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
    string convertTostring(int val){
        if(val == 0) return "0";
        string str ="";
        bool neg = false;
        if(val<0){
            neg = true;
            val = abs(val);
        }
        while(val>0){
            int r1 = val%10;
           char ch = '0'+r1;
            str = ch+str;
            val /= 10;
        }

        if(neg) str = '-' + str;
        return str;
    }
    void solve(TreeNode* root, vector<string> &ans, string str){
        if(root == NULL) return;
        if(root->left==NULL && root->right==NULL){
            str += convertTostring(root->val);
            ans.push_back(str);
            return;
        }
        
        str += convertTostring(root->val);
        str += "->";

        solve(root->left,ans,str);
        solve(root->right,ans,str);

    }
    vector<string> binaryTreePaths(TreeNode* root) {
        vector<string> ans;
        string str;

        solve(root,ans,str);

        return ans;
    }
};