// https://open.kattis.com/problems/froshweek2
import java.util.*;

public class froshweek2 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // # of tasks
		int m = sc.nextInt(); // # of time intervals
		int[] tasks = new int[n]; // length of time of each task
		int[] works = new int[m]; // length of time of each quiet interval
		for(int i = 0; i < n; i++)
		{
			tasks[i] = sc.nextInt();
		}
		for (int j = 0; j < m; j++) 
		{
			works[j] = sc.nextInt();
		}
		// Step 1: Sort lengths from low to high
		Arrays.sort(tasks);
		Arrays.sort(works);

		// Step 2: Greedy
		int num = 0;
		int i = 0;
		int j = 0;
		while (i < n && j < m) 
		{
			// if one can complete the task
			if(tasks[i] <= works[j])
			{
				num++;
				i++;
				j++;
			}
			else
			{
				j++;
			}
		}
		System.out.println(num);
	}
}