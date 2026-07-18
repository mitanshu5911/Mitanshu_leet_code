class Solution {
public:
    double findMaxAverage(vector<int>& nums, int k) {
        int sumOfk = 0;

        for(int i=0; i<k; i++){
            sumOfk += nums[i];
        }

        double max_avg = (double) sumOfk / k;

        for(int i=k; i<nums.size();i++){
            sumOfk = sumOfk + nums[i] - nums[i-k];
            double avg = (double) sumOfk / k;

            max_avg = max(max_avg,avg);
        }
        return max_avg;

    }
};