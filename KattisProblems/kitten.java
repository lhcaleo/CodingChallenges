// https://open.kattis.com/problems/kitten

import java.util.*;
public class kitten 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int kitten = Integer.parseInt(sc.nextLine());
		HashMap<Integer,Integer> map = new HashMap<>();
		
		while(sc.hasNextLine())
		{
			String str = sc.nextLine();
			String[] branches = str.split(" ");
			
			if(Integer.parseInt(branches[0]) == -1)
			{
				break;
			}
			// HashMap: key: b1,b,...,bn  value: same a
			for (int i = 1; i < branches.length; i++) 
			{
				map.put(Integer.parseInt(branches[i]), Integer.parseInt(branches[0]));
			}
		}
		
		getDown(kitten,map);		
	}
	
	// Recursively go from branch b to a
	private static void getDown(int from, Map<Integer,Integer> map)
	{
		if(!map.containsKey(from)) 
		{
			System.out.print(from);
			return;
		}
		else
		{
			System.out.print(from + " ");
			getDown(map.get(from), map);
		}
	}
}