
/*
A 0-indexed array derived with length n is derived by computing the bitwise XOR (⊕) of adjacent values in a binary array original of length n.

Specifically, for each index i in the range [0, n - 1]:

If i = n - 1, then derived[i] = original[i] ⊕ original[0].
Otherwise, derived[i] = original[i] ⊕ original[i + 1].
Given an array derived, your task is to determine whether there exists a valid binary array original that could have formed derived.

Return true if such an array exists or false otherwise.

A binary array is an array containing only 0's and 1's
*/#include <vector>
using namespace std;

class Solution {
public:
    bool doesValidArrayExist(vector<int>& derived) {
        int n = derived.size();

        // Check with original[0] = 0
        if (isValid(derived, 0)) return true;
        // Check with original[0] = 1
        if (isValid(derived, 1)) return true;

        return false;
    }

private:
    bool isValid(const vector<int>& derived, int first) {
        int n = derived.size();
        vector<int> original(n);
        original[0] = first;

        // Reconstruct the original array
        for (int i = 0; i < n - 1; ++i) {
            original[i + 1] = original[i] ^ derived[i];
        }

        // Check cyclic consistency
        return (original[n - 1] ^ original[0]) == derived[n - 1];
    }
};
