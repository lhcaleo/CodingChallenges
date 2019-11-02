// https://open.kattis.com/problems/busnumbers

import java.util.*;
import java.awt.*;

public class busnumbers {
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		int length =  scanner.nextInt();
		// corner case
		if(length < 1)
		{
			System.out.println("");
			return;
		}
		if(length == 1)
		{
			System.out.println(scanner.nextInt());
			return;
		}
		int[] buses = new int[length];
		for(int i = 0; i < length; i++)
		{
			buses[i] = scanner.nextInt();
		}	

		
		Arrays.sort(buses);
	
		String result = "";
		for(int i = 0; i < length; i++)
		{
			int p = buses[i];
			int inc = 1;
			int end = i;
			for(int j = i+1; j < length; j++)
			{
				int curr = buses[j];
				
				if(curr == p + inc)
				{
					inc++;
					end = j;
				}
				else 
				{
					break;
				}
			}

			if(end - i > 1)
			{
				//sequence find
				result += Integer.toString(buses[i]) + "-" + Integer.toString(buses[end]) + " ";
				i = end;
			}
			else 
			{
				result += Integer.toString(buses[i]) + " ";
			}
		}
		System.out.println(result);
	
		
	}
}