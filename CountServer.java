class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // Step 1: Count servers in each row and each column
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Step 2: Populate rowCount and colCount
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }

        // Step 3: Count servers that communicate with others
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // If this server can communicate with others in the same row or column
                    if (rowCount[i] > 1 || colCount[j] > 1) {
                        result++;
                    }
                }
            }
        }

        return result;
    }
}
