import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        Map<Integer, Integer> dp = new HashMap<>();
        int maxLen = 0;
        
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int x = arr[j], y = arr[i];
                int prev = x + y;
                int k = indexMap.getOrDefault(prev, -1);
                
                if (k > i) {
                    int len = dp.getOrDefault(j * n + i, 2) + 1;
                    dp.put(i * n + k, len);
                    maxLen = Math.max(maxLen, len);
                }
            }
        }
        
        return maxLen >= 3 ? maxLen : 0;
    }
}
