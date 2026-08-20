class Solution {
public:
    vector<int> resultArray(vector<int>& nums) {
        int n= nums.size();
        vector<int> arr1,arr2;

        arr1.push_back(nums[0]);
        arr2.push_back(nums[1]);
        int j = 0,k=0;
        for(int i=2; i<n; i++){
            if(arr1[j] > arr2[k]) {
                arr1.push_back(nums[i]);
                j++;
            }
            else{
                arr2.push_back(nums[i]);
                k++;
            }
        }

        vector<int> arr;
        for(int a:arr1){
            arr.push_back(a);
        }
        for(int b:arr2){
            arr.push_back(b);
        }
        return arr;
    }
};