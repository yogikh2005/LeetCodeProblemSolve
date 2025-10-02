/*
Given an array nums containing n distinct numbers in the range [0, n], return the only number in the range that is missing from the array.

 

Example 1:

Input: nums = [3,0,1]

Output: 2

Explanation:

n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.

Example 2:

Input: nums = [0,1]

Output: 2

Explanation:

n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.

Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]

Output: 8

Explanation:

n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
*/
class Solution {
   public int missingNumber(int[] nums) {
        int n = nums.length;
        int xor1 = 0, xor2 = 0;

        // XOR all array elements
        for (int i = 0; i < n; i++) {
            xor1 ^= nums[i];
            xor2 ^= i;
        }

        // include 'n' in xor2
        xor2 ^= n;

        // missing number
        return xor1 ^ xor2;
    }
}
