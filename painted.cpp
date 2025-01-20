/*
You are given a 0-indexed integer array arr, and an m x n integer matrix mat. arr and mat both contain all the integers in the range [1, m * n].

Go through each index i in arr starting from index 0 and paint the cell in mat containing the integer arr[i].

Return the smallest index i at which either a row or a column will be completely painted in mat.
*/
class Solution {
public:
    int firstCompleteIndex(vector<int>& arr, vector<vector<int>>& mat) {
        int m = mat.size();
        int n = mat[0].size();

        // Create a mapping of numbers to their matrix coordinates
        unordered_map<int, pair<int, int>> position;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                position[mat[i][j]] = {i, j};
            }
        }

        // Row and column painting counters
        vector<int> row_count(m, 0);
        vector<int> col_count(n, 0);

        // Iterate through arr to paint the cells
        for (int i = 0; i < arr.size(); ++i) {
            auto [r, c] = position[arr[i]];
            
            // Increment the counters for the corresponding row and column
            row_count[r]++;
            col_count[c]++;
            
            // Check if the row or column is completely painted
            if (row_count[r] == n || col_count[c] == m) {
                return i;
            }
        }

        return -1; // Should not reach here
    }
};
