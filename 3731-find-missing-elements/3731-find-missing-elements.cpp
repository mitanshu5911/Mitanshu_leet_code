class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        unordered_map<int,int> mpp;
        int min_ele = nums[0];
        int max_ele = nums[0];

        for(int num:nums){
            mpp[num]++;
            min_ele = min(min_ele, num);
            max_ele = max(max_ele, num);
        }
        vector<int> res;
        for(int i=min_ele+1; i<max_ele; i++){
            if(!mpp[i]){
                res.push_back(i);
            }
        }

        return res;

    }
};