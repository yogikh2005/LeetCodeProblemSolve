class Solution {
    
    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public int gcdOfOddEvenSums(int n) {
        
        int sumOdd = n * n;

    
        int sumEven = n * (n + 1);

        return gcd(sumOdd, sumEven);
    }
}
