class Solution {
public:
    bool isPowerOfThree(int n) {
        // Powers of 3 must be positive, and must perfectly divide 3^19
        return n > 0 && 1162261467 % n == 0;
    }
};