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
		if (start >= end) 
			return;

		int piv_index = partition(arr, start ,end);
		quickSort(arr, start, piv_index - 1);
		quickSort(arr, piv_index + 1, end);
	}
	
	private static int partition(int[] arr, int start, int end)
	{
		// take first element as pivot
		int pivot = arr[start];
		// index of pivot's next element 
		int wall = start + 1;

		// iterate from second index to last index
		for (int i = start + 1; i <= end; i++)
		{
			// if the number is less than pivot, swap them
			if (arr[i] < pivot)
			{
				// swap arr[i] and arr[k]
				swap(arr, i, wall);
				wall++;
			}
		}
		wall = wall - 1; //move pointer one-step back after iteration
		
		// put the pivot element in its proper place
		// 		swap the pivot: arr[start] 
		// 			and the last element that is smaller than it: arr[k-1]
		swap(arr, start, wall);
				
		// then all the numbers before pivot is less than the pivot
		// 		all the numbers after pivot is greater than the pivot
		// return the position of pivot
		return wall;
	}
	
	private static void swap(int[] arr, int a, int b)
	{
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}