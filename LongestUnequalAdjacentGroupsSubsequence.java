import java.util.*;

class Solution {
    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Building the graph with valid transitions
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && groups[i] != groups[j] && words[i].length() == words[j].length() && hammingDistance(words[i], words[j]) == 1) {
                    graph[i].add(j);
                }
            }
        }

        // DP setup for longest path
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(parent, -1);

        int maxLength = 1, endIndex = 0;

        // DP to find longest path
        for (int i = 0; i < n; i++) {
            for (int next : graph[i]) {
                if (dp[i] + 1 > dp[next]) {
                    dp[next] = dp[i] + 1;
                    parent[next] = i;
                    if (dp[next] > maxLength) {
                        maxLength = dp[next];
                        endIndex = next;
                    }
                }
            }
        }

        // Backtrack to construct the result
        List<String> result = new LinkedList<>();
        while (endIndex != -1) {
            result.add(0, words[endIndex]);
            endIndex = parent[endIndex];
        }

        return result;
    }

    // Method to calculate Hamming distance between two strings
    private int hammingDistance(String s1, String s2) {
        int distance = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }
}
