class Solution {
public:
    vector<int> findDegrees(vector<vector<int>>& matrix) {
        int n=matrix.size();

        vector<int> res(n,0);

        for(int i=0; i<n; i++){
            int sum=0;
            for(int j=0; j<n; j++){
                sum += matrix[i][j];
            }

            res[i] = sum;
        }

        return res;
    }
};