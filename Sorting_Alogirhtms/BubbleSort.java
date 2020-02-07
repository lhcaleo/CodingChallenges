import java.util.Arrays;
public class BubbleSort 
{
	public static void main(String[] args) 
	{
		int[] arr = new int[] {3, 4, 6, 7, 2, 10, 1};
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	private static void bubbleSort(int[] arr)
	{
		int swapTemp = 0;
		
		for (int i = 0; i < arr.length - 1; i++)
		{
			for (int j = 0; j < arr.length - 1 - i; j++)
			{
				if (arr[j] > arr[j + 1])
				{
					//sway arr[j] and arr[j+1]
					swapTemp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = swapTemp;
				}
			}
		}
	}
}