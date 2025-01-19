/*
Given an m x n integer matrix heightMap representing the height of each unit cell in a 2D elevation map, return the volume of water it can trap after raining.

 
Input: heightMap = [[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]
Output: 4
Explanation: After the rain, water is trapped between the blocks.
We have two small ponds 1 and 3 units trapped.
The total volume of water trapped is 4.
  */
#include <vector>
#include <queue>
#include <algorithm>
using namespace std;

class Solution {
public:
    int trapRainWater(vector<vector<int>>& heightMap) {
        if (heightMap.empty() || heightMap[0].empty()) return 0;
        
        int m = heightMap.size(), n = heightMap[0].size();
        vector<vector<bool>> visited(m, vector<bool>(n, false));
        priority_queue<pair<int, pair<int, int>>, vector<pair<int, pair<int, int>>>, greater<>> minHeap;

        // Add all boundary cells to the min-heap and mark them as visited
        for (int i = 0; i < m; i++) {
            minHeap.push({heightMap[i][0], {i, 0}});
            minHeap.push({heightMap[i][n - 1], {i, n - 1}});
            visited[i][0] = visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            minHeap.push({heightMap[0][j], {0, j}});
            minHeap.push({heightMap[m - 1][j], {m - 1, j}});
            visited[0][j] = visited[m - 1][j] = true;
        }

        // Directions for traversing neighbors
        vector<pair<int, int>> directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int waterTrapped = 0;

        while (!minHeap.empty()) {
            auto [currentHeight, cell] = minHeap.top();
            minHeap.pop();
            int x = cell.first, y = cell.second;

            for (auto [dx, dy] : directions) {
                int nx = x + dx, ny = y + dy;
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    // Calculate trapped water
                    waterTrapped += max(0, currentHeight - heightMap[nx][ny]);
                    // Update the height to the max of currentHeight and neighbor's height
                    minHeap.push({max(currentHeight, heightMap[nx][ny]), {nx, ny}});
                }
            }
        }

        return waterTrapped;
    }
};
