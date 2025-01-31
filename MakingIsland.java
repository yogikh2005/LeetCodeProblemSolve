/*
You are given an n x n binary matrix grid. You are allowed to change at most one 0 to be 1.

Return the size of the largest island in grid after applying this operation.

An island is a 4-directionally connected group of 1s.

 

Example 1:

Input: grid = [[1,0],[0,1]]
Output: 3
Explanation: Change one 0 to 1 and connect two 1s, then we get an island with area = 3.
*/
class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int maxArea = 0;
        int islandId = 2; // Start labeling islands from 2
        Map<Integer, Integer> areaMap = new HashMap<>(); // Map to store island sizes
        
        // Step 1: Identify all islands and calculate their areas
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, islandId);
                    areaMap.put(islandId, area);
                    maxArea = Math.max(maxArea, area);
                    islandId++;
                }
            }
        }
        
        // Step 2: Try changing each 0 to 1 and calculate the largest possible island
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> seenIslands = new HashSet<>();
                    int newArea = 1; // Count the changed cell itself
                    
                    for (int[] dir : new int[][]{{0,1},{1,0},{0,-1},{-1,0}}) {
                        int x = i + dir[0], y = j + dir[1];
                        if (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] > 1) {
                            int island = grid[x][y];
                            if (!seenIslands.contains(island)) {
                                newArea += areaMap.get(island);
                                seenIslands.add(island);
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, newArea);
                }
            }
        }
        
        return maxArea;
    }
    
    private int dfs(int[][] grid, int i, int j, int islandId) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) return 0;
        
        grid[i][j] = islandId; // Mark the cell with the island id
        int area = 1;
        
        for (int[] dir : new int[][]{{0,1},{1,0},{0,-1},{-1,0}}) {
            area += dfs(grid, i + dir[0], j + dir[1], islandId);
        }
        
        return area;
    }
}
