/*169. Majority Element
Easy
Topics
premium lock icon
Companies
Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.

 

Example 1:

Input: nums = [3,2,3]
Output: 3
Example 2:

Input: nums = [2,2,1,1,1,2,2]
Output: 2
 

Constraints:

n == nums.length
1 <= n <= 5 * 104
-109 <= nums[i] <= 109
*/
class Solution {
    public int majorityElement(int[] nums) {
       int l=nums.length;
       for(int i=0;i<l;i++)
       {
        int cnt=0;
        for(int j=0;j<l;j++)
        {
            if(nums[j]==nums[i])
                cnt++;
        }
        if(cnt>l/2)
            return nums[i];
       }
       return -1;
    }
}
