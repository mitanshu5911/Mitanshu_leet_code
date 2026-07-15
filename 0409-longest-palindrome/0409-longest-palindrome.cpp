class Solution {
public:
    int longestPalindrome(string s) {
        unordered_map<char,int> mp;
        int ans = 0;

        for(char c : s) mp[c]++;

        for(auto &[c,f] : mp){
            ans += (f/2)*2;
            if(ans%2==0 && f%2) ans++;
        }

        return ans;
    }
};