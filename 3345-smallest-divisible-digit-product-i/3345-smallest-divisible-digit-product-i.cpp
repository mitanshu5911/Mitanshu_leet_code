class Solution {
public:
    int findProduct(int n){
        int pro = 1;
        while(n>0){
            int r1 = n%10;
            pro *= r1;
            n /=10;
        }
        return pro;

    }
    int smallestNumber(int n, int t) {
        int ans = 0;
        for(int i=n; i<=100; i++){
            int product = findProduct(i);

            if(product%t==0){
                ans = i;
                break;
            }
        }
        return ans;
    }
}; 