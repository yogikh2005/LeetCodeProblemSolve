class Solution {
    static final int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        long evenCount = (n + 1) / 2;  // ceil(n/2)
        long oddCount = n / 2;         // floor(n/2)
        
        long evenPower = modPow(5, evenCount, MOD);
        long oddPower = modPow(4, oddCount, MOD);
        
        return (int)(evenPower * oddPower % MOD);
    }

    private long modPow(long base, long exponent, int mod) {
        long result = 1;
        base %= mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1)
                result = result * base % mod;
            base = base * base % mod;
            exponent >>= 1;
        }
        return result;
    }
}
