/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
Given a roman numeral, convert it to an integer.
*/
class Solution {
public:
    int romanToInt(string s) {
        // Map of Roman numerals to their integer values
        unordered_map<char, int> romanMap = {
            {'I', 1}, {'V', 5}, {'X', 10}, {'L', 50},
            {'C', 100}, {'D', 500}, {'M', 1000}
        };

        int result = 0;
        int n = s.length();

        for (int i = 0; i < n; ++i) {
            // If the current numeral is less than the next, subtract its value
            if (i < n - 1 && romanMap[s[i]] < romanMap[s[i + 1]]) {
                result -= romanMap[s[i]];
            } else {
                // Otherwise, add its value
                result += romanMap[s[i]];
            }
        }

        return result;
    }
};
