// https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/
// Note extra space for another array is not allowed 
// Two-pointer solution O(n) time, O(1) memory
class Solution 
{
    public int removeDuplicates(int[] nums) 
    {
        // Corner case
        if(nums.length == 1 || nums.length == 0)
            return nums.length; 
        // Two-pointer strategy
        int i = 0;
        for (int j = 1; j < nums.length; j++)
        {
            // If differs, store nums[j] into new positon in array
            // at the same time, increment i
            if(nums[i] != nums[j])
            {
                nums[++i] = nums[j];
            }
            // If same, only increment pointer j
        }
        // i is the index of last element in array
        // i + 1 is the actual length of the modified array
        return i + 1;
    }
}
