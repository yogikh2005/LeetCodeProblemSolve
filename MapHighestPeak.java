import java.util.*;

class MapHighestPeak {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length;
        int n = isWater[0].length;

        int[][] height = new int[m][n];
        for (int[] row : height) {
            Arrays.fill(row, -1); // Initialize all cells to -1 (unvisited)
        }

        Queue<int[]> queue = new LinkedList<>();
        
        // Initialize the queue with all water cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0; // Water cells have height 0
                    queue.offer(new int[] {i, j}); // Add water cell to the queue
                }
            }
        }

        // Directions for moving to adjacent cells (north, east, south, west)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                // Check if the new cell is within bounds and unvisited
                if (newX >= 0 && newX < m && newY >= 0 && newY < n && height[newX][newY] == -1) {
                    height[newX][newY] = height[x][y] + 1; // Set height of the new cell
                    queue.offer(new int[] {newX, newY}); // Add the new cell to the queue
                }
            }
        }

        return height;
    }
}
