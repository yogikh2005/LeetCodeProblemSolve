import java.util.*;

class Solution {
    private static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {
        // Step 1: Generate all valid row states for width 'm'
        List<Integer> validRows = generateValidRows(m);
        int rowCount = validRows.size();

        // Step 2: Build a transition graph between valid rows
        List<Integer>[] transitions = buildTransitions(validRows, m);

        // Step 3: Initialize DP table
        long[][] dp = new long[n][rowCount];

        // Base case: first column
        Arrays.fill(dp[0], 1);

        // Step 4: Fill DP table for each column
        for (int col = 1; col < n; col++) {
            for (int i = 0; i < rowCount; i++) {
                for (int next : transitions[i]) {
                    dp[col][next] = (dp[col][next] + dp[col - 1][i]) % MOD;
                }
            }
        }

        // Step 5: Sum all ways for the last column
        long result = 0;
        for (long ways : dp[n - 1]) {
            result = (result + ways) % MOD;
        }

        return (int) result;
    }

    // Function to generate all valid rows for the given width 'm'
    private List<Integer> generateValidRows(int m) {
        List<Integer> validRows = new ArrayList<>();
        generateRow(m, 0, 0, validRows);
        return validRows;
    }

    // Recursive function to generate row combinations
    private void generateRow(int m, int pos, int row, List<Integer> validRows) {
        if (pos == m) {
            validRows.add(row);
            return;
        }

        for (int color = 1; color <= 3; color++) {
            if (pos == 0 || (row % 3) != (color - 1)) {
                generateRow(m, pos + 1, row * 3 + (color - 1), validRows);
            }
        }
    }

    // Function to build transitions between valid rows
    private List<Integer>[] buildTransitions(List<Integer> validRows, int m) {
        int rowCount = validRows.size();
        List<Integer>[] transitions = new ArrayList[rowCount];

        for (int i = 0; i < rowCount; i++) {
            transitions[i] = new ArrayList<>();
            for (int j = 0; j < rowCount; j++) {
                if (areRowsCompatible(validRows.get(i), validRows.get(j), m)) {
                    transitions[i].add(j);
                }
            }
        }

        return transitions;
    }

    // Function to check if two rows are compatible
    private boolean areRowsCompatible(int row1, int row2, int m) {
        for (int i = 0; i < m; i++) {
            if ((row1 % 3) == (row2 % 3)) return false;
            row1 /= 3;
            row2 /= 3;
        }
        return true;
    }
}
