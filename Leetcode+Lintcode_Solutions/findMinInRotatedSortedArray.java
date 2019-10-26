// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// O(n) solution, iterate the array and return if the next element is smaller than current min
class Solution 
{
    public int findMin(int[] nums) 
    {
        int min = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(nums[i] < min)
            {
                return nums[i];
            }
        }
        return min;
    }
}