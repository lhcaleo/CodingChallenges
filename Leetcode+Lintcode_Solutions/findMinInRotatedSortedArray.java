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
// O(log n) solution, binary search
class Solution {
    public int findMin(int[] nums) 
    {
        // Corner case
        if (nums == null || nums.length == 0) 
        { 
            return -1;
        }
        int left = 0, right = nums.length - 1;
        
        // Stop the while loop when we have only one element, it's the minimun one
        while (left < right) 
        { 
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) 
            {
                // skip the nums[mid] since it is already greater
                left = mid + 1; 
            } 
            else 
            {
                right = mid;
            }
        }
        return nums[left]; // return the only element left
    }
}
