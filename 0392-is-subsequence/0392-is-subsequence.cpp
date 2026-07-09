class Solution {
public:
    vector<vector<int>> dp;

    bool solve(int i, int j, string &s, string &t) {
        if (i == s.size()) return true;
        if (j == t.size()) return false;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (s[i] == t[j]) {
            return dp[i][j] = solve(i + 1, j + 1, s, t) ||
                              solve(i, j + 1, s, t);
        }

        return dp[i][j] = solve(i, j + 1, s, t);
    }

    bool isSubsequence(string s, string t) {
        dp.assign(s.size() + 1, vector<int>(t.size() + 1, -1));
        return solve(0, 0, s, t);
    }
};