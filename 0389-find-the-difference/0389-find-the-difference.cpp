class Solution {
public:
    char findTheDifference(string s, string t) {
        int freq[27] = {0};
        for(char ch:t) freq[ch - 'a' + 1]++;

        for(char ch:s) freq[ch - 'a' + 1]--;

        int ele=-1;
        for(int i=0; i<27; i++){
            if(freq[i] == 1){
                ele = i;
                break;
            }
        }

        char ch = ele -1  + 'a';
        return ch;
    }
};