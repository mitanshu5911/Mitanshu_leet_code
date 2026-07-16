class Solution {
public:
    vector<bool> kidsWithCandies(vector<int>& candies, int extraCandies) {
        vector<bool> arr;
        int max_ele = 0;
        for(int num:candies) max_ele = max(num,max_ele);

        for(int num:candies){
            if(num+extraCandies>=max_ele) arr.push_back(true);
            else arr.push_back(false);
        }
        return arr;
    }
};