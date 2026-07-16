class Solution {
public:
   long long gcd(long long a, long long b) {
    while (b) {
        long long t = a % b;
        a = b;
        b = t;
    }
    return a;
}
    long long gcdSum(vector<int>& nums) {
        int n=nums.size();
        vector<long long > prefixGcd;
        
        long long  max_ele = 0;

        for(int i=0; i<n; i++){
             max_ele = max(max_ele,1LL*nums[i]);

            long long  preGcd = gcd(max_ele,1LL*nums[i]);

            prefixGcd.push_back(preGcd);
        }

        sort(begin(prefixGcd), end(prefixGcd));

        int i=0;
        int j=prefixGcd.size()-1;

        long long sum = 0;
        while(i<j){
            sum += gcd(prefixGcd[i],prefixGcd[j]);
            i++;
            j--;
        }
        return sum;
    }
};