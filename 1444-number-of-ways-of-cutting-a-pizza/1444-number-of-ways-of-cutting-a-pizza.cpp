class Solution {
public:
    int m,n;
    int apples[55][55];
    int dp[55][55][15];

    long long MOD = 1e9 + 7;

    int solve(int i, int j, int k){
        if(apples[i][j] < k)return 0;

        if(k==1){
            if(apples[i][j] >=1)
                return 1;
            return 0;
        }

        if(dp[i][j][k] != -1) return dp[i][j][k];

        int ans = 0;

        for(int h = i+1; h<m; h++){
            int lower_slice_apples = apples[h][j];

            int upper_slice_apples = apples[i][j] - lower_slice_apples;

            if(upper_slice_apples>=1 && lower_slice_apples >= k-1){
               ans = ((ans)%MOD +  (solve(h,j,k-1))%MOD)%MOD;
            }
        }


        for(int v = j+1; v<n; v++){
            int right_slice_apples = apples[i][v];

            int left_slice_apples = apples[i][j] - right_slice_apples;

            if(left_slice_apples>=1 && right_slice_apples >= k-1 ){
                ans = ((ans)%MOD +  (solve(i,v,k-1))%MOD)%MOD;
            }
        }
        return dp[i][j][k] = ans;
    }

    int ways(vector<string>& pizza, int k) {
        m = pizza.size();
        n = pizza[0].length();

        memset(apples,0,sizeof(apples));

        for(int i=m-1; i>=0; i--){
            for(int j=n-1; j>=0;j--){
                apples[i][j] = apples[i][j+1];

                for(int l=i; l<m;l++){
                    if(pizza[l][j] == 'A')apples[i][j] +=1;
                }
            }
        }
        memset(dp,-1,sizeof(dp));
        return solve(0,0,k);
    }
};