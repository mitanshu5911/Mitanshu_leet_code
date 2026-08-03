class Solution {
public:
    int n;
    vector<int> t;
    
    string stoneGameIII(vector<int>& arr) {
        n = arr.size();
        t.resize(n+1,0);

        for(int i=n-1; i>=0; i--){
            t[i] = arr[i] - t[i+1];

            if(i+1<n && i+2<=n)
            t[i] = max(t[i], arr[i] + arr[i+1] - t[i+2]);

            if(i+1<n && i+2<n && i+3<=n)
            t[i] = max(t[i], arr[i] + arr[i+1] + arr[i+2] - t[i+3]);


        }
        int diff = t[0];

        if(diff < 0) return "Bob";
        else if(diff > 0) return "Alice";

        return "Tie";

    }
};