

import java.util.*;

class Solution {
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;

        // Directions for moving up, down, left, right
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Min-heap priority queue (time, x, y)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        pq.offer(new int[]{0, 0, 0}); // Start at (0,0) with time 0

        // Min-time to reach each cell
        int[][] minTime = new int[n][m];
        for (int[] row : minTime) Arrays.fill(row, Integer.MAX_VALUE);
        minTime[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int time = current[0], x = current[1], y = current[2];

            // If we have reached the destination
            if (x == n - 1 && y == m - 1) return time;

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int nextTime = Math.max(time + 1, moveTime[nx][ny]);

                    if (nextTime < minTime[nx][ny]) {
                        minTime[nx][ny] = nextTime;
                        pq.offer(new int[]{nextTime, nx, ny});
                    }
                }
            }
        }

        return -1; // Unreachable (should not happen under problem constraints)
    }
}
