class Solution {
public:
    string mergeAlternately(string word1, string word2) {

       int i=0,j=0,n=word1.size(),m=word2.size();
        string str = "";
       while(i<n && j<m){
            str += word1[i++];
            str += word2[j++];
       }

       while(i<n) str += word1[i++];
       while(j<m) str += word2[j++];

        return str;
    }
};