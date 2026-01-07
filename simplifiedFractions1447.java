import java.util.*;

class Solution {
    public List<String> simplifiedFractions(int n) {
        List<String> result = new ArrayList<>();

        for (int denom = 2; denom <= n; denom++) {
            for (int num = 1; num < denom; num++) {
                if (gcd(num, denom) == 1) {
                    result.add(num + "/" + denom);
                }
            }
        }
        return result;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
