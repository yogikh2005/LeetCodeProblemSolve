/*
You are given two 0-indexed arrays, nums1 and nums2, consisting of non-negative integers. There exists another array, nums3, which contains the bitwise XOR of all pairings of integers between nums1 and nums2 (every integer in nums1 is paired with every integer in nums2 exactly once).

Return the bitwise XOR of all integers in nums3.

 
*/
class Solution {
public:
    int xorAllNums(vector<int>& nums1, vector<int>& nums2) {
        int xor1 = 0, xor2 = 0;
        
        // Compute XOR of nums1
        for (int num : nums1) {
            xor1 ^= num;
        }
        
        // Compute XOR of nums2
        for (int num : nums2) {
            xor2 ^= num;
        }
        
        // Determine the result based on array lengths
        int result = 0;
        if (nums2.size() % 2 == 1) {
            result ^= xor1;
        }
        if (nums1.size() % 2 == 1) {
            result ^= xor2;
        }
        
        return result;
    }
};
