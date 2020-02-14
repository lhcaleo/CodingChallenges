import java.util.Arrays;
public class InsertionSort
{
	public static void main(String[] args) 
	{
		int[] arr = new int[] {3, 4, 6, 7, 2, 10, 1};
		insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void insertionSort(int[] arr)
	{
		// insert current element into sorted array on the left, and keep it sorted
		for (int i = 0; i < arr.length; i++) 
		{
			int temp = arr[i];
			int j = i;
			// if elements on the left is greater than temp
			// move it to the right
			while (j > 0 && arr[j-1] > temp)
			{
				arr[j] = arr[j-1];
				j--;
			}
			// move current element to its correct position
			arr[j] = temp;
		}
	}
}