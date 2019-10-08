import java.util.*;

public class trik {
	public static void main(String[] args) {
		//Use scanner to get input
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		sc.close();
		//Start with position at 1
		int position = 1;
		char move;
		//Iterate all the moves and track the position
		for(int i = 0; i < str.length(); i++)
		{
			move = str.charAt(i);
			if(position==1)
			{
				if(move=='A') position++;
				else if (move=='C') position += 2;
			}
			else if (position==2) 
			{
				if(move=='A') position--;
				else if (move=='B') position++;
			}
			else
			{
				if(move=='B') position--;
				else if (move=='C') position -= 2;
			}
		}
		System.out.println(position);
	}
}