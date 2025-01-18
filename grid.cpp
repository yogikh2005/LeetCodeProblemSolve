class Solution {
public:
    int minCost(vector<vector<int>>& grid) {
        int m = grid.size(), n = grid[0].size();
        vector<vector<int>> directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        vector<vector<int>> cost(m, vector<int>(n, INT_MAX));
        deque<pair<int, int>> dq; // {row, col}
        
        dq.push_front({0, 0});
        cost[0][0] = 0;

        while (!dq.empty()) {
            auto [x, y] = dq.front();
            dq.pop_front();

            for (int dir = 0; dir < 4; ++dir) {
                int nx = x + directions[dir][0];
                int ny = y + directions[dir][1];
                int newCost = cost[x][y] + (grid[x][y] == dir + 1 ? 0 : 1);

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && newCost < cost[nx][ny]) {
                    cost[nx][ny] = newCost;
                    if (grid[x][y] == dir + 1)
                        dq.push_front({nx, ny}); // Prioritize zero-cost moves
                    else
                        dq.push_back({nx, ny}); // Add costly moves to the back
                }
            }
        }

        return cost[m - 1][n - 1];
    }
};
