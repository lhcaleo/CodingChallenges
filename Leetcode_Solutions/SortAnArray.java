// Bubble Sort
{
	public List<Integer> sortArray(int[] nums) 
	{
		if (nums.length == 0 || nums.length == 1) 
			return arrayToList(nums);     
		
		for (int i = 0; i < nums.length; i++)
		{
			int swapTemp = 0;
			for (int j = 0; j < nums.length - i - 1; j++)
			{
				if (nums[j] > nums[j + 1])
				{
					swapTemp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = swapTemp;
				}    
			}
		}
		return arrayToList(nums); 
	}
	
	private List<Integer> arrayToList(int[] nums)
	{
		List<Integer> result = new ArrayList<>();
		for (int num: nums)
		{
			result.add(num);
		}
		return result;
	}
}

// merge Sort
{
	public List<Integer> sortArray(int[] nums) 
	{
		if (nums.length == 0 || nums.length == 1) 
			return arrayToList(nums);     
		
		mergeSort(nums, 0, nums.length - 1);
		return arrayToList(nums);
	}
	
	private void mergeSort(int[] nums, int start, int end)
	{
		if (start >= end) return;
		int mid = (start + end) / 2;
		// divide
		mergeSort(nums, start, mid);
		mergeSort(nums, mid + 1, end);
		// merge
		merge(nums, start, mid, end);
	}
	
	private void merge(int[] nums, int start, int mid, int end)
	{
		int[] temp = new int[end - start + 1];
		
		// pointer for left portion
		int i = start;
		// pointer for right portion
		int j = mid + 1;
		// pointer for the combined array
		int k = 0;
		
		while (i <= mid && j <= end)
		{
			if (nums[i] < nums[j])
			{
				temp[k++] = nums[i++];
			} else {
				temp[k++] = nums[j++];
			}
		}
		
		// when left portion is not finished
		while (i <= mid)
		{
			temp[k++] = nums[i++];
		}
		while (j <= end)
		{
			temp[k++] = nums[j++];
		}
		// copy values into actual array
		for (int c = 0; c < temp.length; c++)
		{
			nums[start + c] = temp[c];
		}
	}    
	
	private List<Integer> arrayToList(int[] nums)
	{
		List<Integer> result = new ArrayList<>();
		for (int num: nums)
		{
			result.add(num);
		}
		return result;
	}
}

// quick sort, in this case faster than merge sort
// however, quick sort is not stable
class Solution 
{
	public List<Integer> sortArray(int[] nums) 
	{
		if (nums.length == 0 || nums.length == 1) 
			return arrayToList(nums);     
		
		quickSort(nums, 0, nums.length - 1);
		return arrayToList(nums);
	}
	
	private void quickSort(int[] nums, int start, int end)
	{
		if (start >= end) return;
		
		int pivot_index = partition(nums, start, end);
		quickSort(nums, start, pivot_index - 1);
		quickSort(nums, pivot_index + 1, end);
	}
	
	private int partition(int[] nums, int start, int end)
	{
		int pivot = nums[start];
		int k = start + 1;
		
		int swapTemp = 0;
		
		for (int i = start + 1; i <= end; i++)
		{
			if (nums[i] < pivot)
			{
				swapTemp = nums[i];
				nums[i] = nums[k];
				nums[k] = swapTemp;
				k++;
			}
		}
		
		k--;
		
		swapTemp = nums[start];
		nums[start] = nums[k];
		nums[k] = swapTemp;
		return k;
	}
	
	private List<Integer> arrayToList(int[] nums)
	{
		List<Integer> result = new ArrayList<>();
		for (int num: nums)
		{
			result.add(num);
		}
		return result;
	}
}