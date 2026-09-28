class Solution {
public:
    vector<string> findWords(vector<string>& words) {
        unordered_map<char, int> row;

        // First row
        for(char c : string("qwertyuiop")) {
            row[c] = 1;
        }

        // Second row
        for(char c : string("asdfghjkl")) {
            row[c] = 2;
        }

        // Third row
        for(char c : string("zxcvbnm")) {
            row[c] = 3;
        }

        vector<string> ans;

        for(string word : words) {
            int r = row[tolower(word[0])];
            bool valid = true;

            for(char c : word) {
                if(row[tolower(c)] != r) {
                    valid = false;
                    break;
                }
            }

            if(valid) {
                ans.push_back(word);
            }
        }

        return ans;
    }
};