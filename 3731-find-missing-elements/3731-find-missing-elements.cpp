class Solution {
public:
    vector<int> findMissingElements(vector<int>& nums) {
        
        int min_ele = nums[0];
        int max_ele = nums[0];

        for(int num:nums){
            min_ele = min(min_ele, num);
            max_ele = max(max_ele, num);
        }

        vector<int> freq(max_ele+1);
        for(int num:nums){
            freq[num] = 1;
        }

        vector<int> res;
        for(int i=min_ele+1; i<max_ele; i++){
            if(freq[i] == 0) res.push_back(i);
        }

        return res;

    }
};