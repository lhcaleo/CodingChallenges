// https://leetcode.com/problems/merge-sorted-array/submissions/
// O(m+n) time without extra memory
// two-pointer solution
class Solution 
{
    public void merge(int[] nums1, int m, int[] nums2, int n) 
    {
        int i = m - 1;     // from end of nums1
        int j = n - 1;     // from end of nums2
        int k = m + n - 1; // from end of merged array
        while(i >= 0 && j >= 0)
		{
            // if element in nums1 is greater than the element in nums2
            // store it into merged array
            // and then compare its left element with that element
            if(nums1[i] > nums2[j])
			    nums1[k--] = nums1[i--];
            // if element in nums1 is smaller or equal to the element in nums2
            // store the element in nums2 into merged array
            // and them compare the left element of that greater element in nums2
			else
                nums1[k--] = nums2[j--];
		}
        // store the rest elements in nums2 into sorted array
		while(j >= 0)
        {
            nums1[k--] = nums2[j--];
        }
    }
}

