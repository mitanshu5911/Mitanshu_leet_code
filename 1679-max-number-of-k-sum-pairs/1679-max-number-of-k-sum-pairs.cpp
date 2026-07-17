class Solution {
public:
    int maxOperations(vector<int>& nums, int k) {
        int count = 0;
        sort(begin(nums),end(nums));

        int i=0;
        int j=nums.size()-1;

        while(i<j){
            if(nums[i]+nums[j] == k){ 
                count++;
                 i++;
                 j--;
            }
            else if(nums[i]+nums[j] > k) j--;
            else i++;
        }

        return count;
    }
};