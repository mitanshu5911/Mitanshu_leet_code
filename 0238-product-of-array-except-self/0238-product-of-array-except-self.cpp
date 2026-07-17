class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        long long product_without_zero = 1;
        int count_zero = 0;

        for(int num:nums){
            if(num == 0){
                count_zero++;
                if(count_zero > 1){

                 product_without_zero = 0; 
                 break;
                }
            }else {
                product_without_zero *= num;
            }
        }

        if(product_without_zero == 0){
            for(int i=0; i<nums.size();i++){
                nums[i] = 0;
            }
        }else{
            for(int i = 0; i<nums.size(); i++){
                if(nums[i] == 0){
                    nums[i] = product_without_zero;
                }else{
                    if(count_zero){
                        nums[i] = 0;
                    }else{
                        nums[i] = product_without_zero / nums[i];
                    }   
                }
            }
        }

        return nums;
    }
};