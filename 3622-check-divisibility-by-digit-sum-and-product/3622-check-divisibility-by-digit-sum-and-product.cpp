class Solution {
public:
    bool checkDivisibility(int n) {
        int sum = 0;
        int product = 1;


        int n1 = n;
        while(n1>0){
            int r1 = n1%10;
            sum += r1;
            product *= r1;

            n1 = n1/10;
        }

        return (n % (sum + product) == 0);

    }
};