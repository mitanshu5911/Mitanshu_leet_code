class Solution {
public:
    int solve(string &s, int i, int j,vector<vector<int>> &t){
        if(i>j) return 0;

        if(i==j) return 1;

        if(t[i][j] != -1) return t[i][j];

        if(s[i] == s[j]){
            return t[i][j] = 2 + solve(s,i+1,j-1,t);
        }else{
            return t[i][j] = max(solve(s,i+1,j,t), solve(s,i,j-1,t));
        }
    }
    int longestPalindromeSubseq(string s) {
        vector<vector<int>> t(1001,vector<int>(1001,-1));
        return solve(s,0,s.length()-1,t);
    }
};