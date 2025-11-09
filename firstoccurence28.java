function strStr(haystack: string, needle: string): number {
    if (needle.length === 0) return 0; // Edge case: empty needle
    return haystack.indexOf(needle);
}
//first occurance in the string 
