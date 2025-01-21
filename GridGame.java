class GridGame {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        
        // Calculate prefix sums for the top and bottom rows
        long[] topPrefix = new long[n + 1];
        long[] bottomPrefix = new long[n + 1];
        
        for (int i = 0; i < n; i++) {
            topPrefix[i + 1] = topPrefix[i] + grid[0][i];
            bottomPrefix[i + 1] = bottomPrefix[i] + grid[1][i];
        }
        
        long result = Long.MAX_VALUE;
        
        // Simulate the first robot's choices
        for (int i = 0; i < n; i++) {
            // Points left on the top row after column i
            long pointsTop = topPrefix[n] - topPrefix[i + 1];
            // Points left on the bottom row before column i
            long pointsBottom = bottomPrefix[i];
            
            // Maximum points the second robot can collect
            long secondRobotScore = Math.max(pointsTop, pointsBottom);
            result = Math.min(result, secondRobotScore);
        }
        
        return result;
    }
}
