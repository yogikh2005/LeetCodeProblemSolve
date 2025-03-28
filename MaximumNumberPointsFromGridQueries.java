import java.util.*;

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int k = queries.length;
        int[] answer = new int[k];
        
        // Sort queries and keep track of original indices
        int[][] sortedQueries = new int[k][2];
        for (int i = 0; i < k; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));
        
        // Min-heap to process cells in increasing order of value
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean[][] visited = new boolean[m][n];
        int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        // Start processing from (0,0)
        minHeap.offer(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;
        int points = 0;
        
        for (int[] query : sortedQueries) {
            int qValue = query[0], index = query[1];
            
            // Process all cells that are less than the current query value
            while (!minHeap.isEmpty() && minHeap.peek()[0] < qValue) {
                int[] cell = minHeap.poll();
                int r = cell[1], c = cell[2];
                points++;
                
                for (int[] d : directions) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        minHeap.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            answer[index] = points;
        }
        
        return answer;
    }
}
