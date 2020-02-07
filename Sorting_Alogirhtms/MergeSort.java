import java.util.Arrays;
public class MergeSort 
{
	public static void main(String[] args) 
	{
		int[] arr = new int[] {3, 4, 6, 7, 2, 10, 1};
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void mergeSort(int[] arr, int start, int end)
	{
		if (start >= end) 
			return;
		int mid = (start + end) / 2;
		// divide
		mergeSort(arr, start, mid);
		mergeSort(arr, mid + 1, end);
		// merge
		merge(arr, start, mid, end);	
	}
	
	private static void merge(int[] arr, int start, int mid, int end)
	{
		int[] temp = new int[end - start + 1];
		
		// pointer for left
		int i = start;
		// pointer for right
		int j = mid + 1;
		// pointer for left + right
		int k = 0;
		
		// fill temp array by comparing element from left and right array
		while (i <= mid && j <= end)
		{
			if (arr[i] < arr[j])
			{
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		
		// when left array is not finished
		while (i <= mid)
		{
			temp[k++] = arr[i++];
		}
		// when right array is not finished
		while (j <= end)
		{
			temp[k++] = arr[j++];
		}
		// copy values to the real array
		for (int a = 0; a < temp.length; a++)
		{
			arr[start + a] = temp[a];
		}
	}	
}