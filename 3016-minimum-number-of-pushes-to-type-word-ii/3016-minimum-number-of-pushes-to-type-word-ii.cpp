class Solution {
public:
    int minimumPushes(string word) {
        int n=word.size();
        sort(word.begin(),word.end());
        int unique_elements = 1;

        for(int i=1; i<n; i++){
            if(word[i]!=word[i-1]) unique_elements++;
        }

        vector<int> freq(unique_elements);
        int j=0;
        for(int i=1; i<n && j<unique_elements;i++){
            if(word[i]!=word[i-1]){
                freq[j]++;
                j++;
            }else{
            freq[j]++;
            }
        }
        if(j<unique_elements) {
            freq[j]++;
        }
        sort(rbegin(freq),rend(freq));
        int pushes = 0;
        if(unique_elements<=8){
            pushes = n;
        }else if(unique_elements<=16){
            for(int i=0;i<8; i++){
                pushes += freq[i];
            }

            for(int i=8; i<unique_elements;i++){
                pushes =pushes+ 2*freq[i];
            }
        }else if(unique_elements <= 24){
            for(int i=0;i<8; i++){
                pushes += freq[i];
            }

             for(int i=8; i<16;i++){
                pushes =pushes+ 2*freq[i];
            }

            for(int i=16; i<unique_elements;i++){
                pushes =pushes+ 3*freq[i];
            }
        }else {
            for(int i=0;i<8; i++){
                pushes += freq[i];
            }

             for(int i=8; i<16;i++){
                pushes =pushes+ 2*freq[i];
            }

            for(int i=16; i<24;i++){
                pushes =pushes+ 3*freq[i];
            }

            for(int i=24; i<unique_elements;i++){
                pushes =pushes+ 4*freq[i];
            }

        }

        return pushes;
    }
};