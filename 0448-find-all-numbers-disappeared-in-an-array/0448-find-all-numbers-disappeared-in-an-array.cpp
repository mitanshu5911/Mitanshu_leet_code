class Solution {
public:
    vector<int> findDisappearedNumbers(vector<int>& nums) {
        vector<int> ans;

        unordered_map<int,int>mpp;

        for(int num:nums)mpp[num]++;

        for(int i=0; i<nums.size(); i++){
            if(mpp.find(i+1)==mpp.end()) ans.push_back(i+1);
        }
        return ans;
    }
};