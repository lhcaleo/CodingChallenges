import java.util.Arrays;
public class QuickSort
{
	public static void main(String[] args) 
	{
		int[] arr = new int[] {3, 4, 6, 7, 2, 10, 1};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void quickSort(int[] arr, int start, int end)
	{
		if (start >= end) return;
		int piv_index = partition(arr, start ,end);
		quickSort(arr, start, piv_index - 1);
		quickSort(arr, piv_index + 1, end);
	}
	
	private static int partition(int[] arr, int start, int end)
	{
		// take first element as pivot
		int pivot = arr[start];
		// index of pivot's next element 
		int k = start + 1;
				
		int swapTemp = 0;
		
		for (int i = start + 1; i <= end; i++)
		{
			if (arr[i] < pivot)
			{
				// swap arr[i] and arr[k]
				swapTemp = arr[i];
				arr[i] = arr[k];
				arr[k] = swapTemp;
				k++;
			}
		}
		k = k - 1; //move pointer one-step back after iteration
		
		// put the pivot element in its proper place
		// swap the pivot: arr[start] 
		// and the last element that is smaller than it: arr[k-1]
		swapTemp = arr[start];
		arr[start] = arr[k];
		arr[k] = swapTemp;
		
		// return the position of pivot
		return k;
	}
	
}