import java.util.Arrays;
public class SelectionSort 
{
	public static void main(String[] args) 
	{
		int[] arr = new int[] {3, 4, 6, 7, 2, 10, 1};
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void selectionSort(int[] arr)
	{
		int min = 0;
		int swapTemp = 0;
		
		for (int i = 0; i < arr.length - 1; i++)
		{
			min = i;
			for (int j = i + 1; j < arr.length; j++)
			{
				if (arr[j] < arr[min])
					min = j;
			}
			// swap arr[i] and arr[min]
			swapTemp = arr[i];
			arr[i] = arr[min];
			arr[min] = swapTemp;
		}
	}
}