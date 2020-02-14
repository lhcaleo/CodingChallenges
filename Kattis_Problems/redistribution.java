// https://open.kattis.com/problems/redistribution
import java.util.*;

public class redistribution
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int students[] = new int[n];
		int pairs[][] = new int[n][2]; // number of students in room, room index
		for(int i = 0; i < n; i++)
		{
			students[i] = sc.nextInt();
			pairs[i][0] = students[i];
			pairs[i][1] = i+1;
		}
		Arrays.sort(pairs, (x, y) -> y[0] - x[0]);

		int checker = 0;
		for(int m = 1; m < n; m++)
		{
			checker += pairs[m][0];
		}
		String result = "";
		if(checker < pairs[0][0]) result = "impossible";
		else
		{
			for(int i = 0; i < n; i++)
			{
				result += pairs[i][1] + " ";
			}
		}
		System.out.println(result);
	}
}