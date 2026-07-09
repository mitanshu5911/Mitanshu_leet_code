class Solution {
public:
    int firstUniqChar(string s) {
        int freq[27] = {0};

        for(char ch : s){
            int idx = ch - 'a' + 1;
            freq[idx]++;
        }
        char ele = ' ';
        for(char ch:s){
            if(freq[ch - 'a' + 1] == 1){
                ele = ch;
                break;
            }
        }

        return s.find(ele);
    }
};