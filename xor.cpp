class Solution {
public:
    int minimizeXor(int num1, int num2) {
        // Step 1: Count the number of set bits in num2
        int setBitsCount = __builtin_popcount(num2);
        
        // Step 2: Construct x with the same number of set bits as num2
        int x = 0;
        // Set bits from num1 where possible
        for (int i = 31; i >= 0 && setBitsCount > 0; --i) {
            if (num1 & (1 << i)) {
                x |= (1 << i);
                setBitsCount--;
            }
        }
        
        // Step 3: If more set bits are needed, set remaining least significant bits
        for (int i = 0; i <= 31 && setBitsCount > 0; ++i) {
            if (!(x & (1 << i))) {  // If the bit is not set in x
                x |= (1 << i);
                setBitsCount--;
            }
        }
        
        return x;
    }
};
