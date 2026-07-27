class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int firstMax = INT_MIN;
        int secondMax = INT_MIN;

        for(int i=0; i<nums.size();i++){
            if(nums[i] >= firstMax){
                secondMax = firstMax;
                firstMax = nums[i];
            }else if(nums[i]>=secondMax && nums[i]!=firstMax){
                secondMax = nums[i];
            }
        }

        
        long long  x = 1LL*(firstMax-1)*(secondMax-1);
        return x;
    }
};