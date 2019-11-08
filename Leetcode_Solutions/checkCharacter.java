// Given a character, return true if it is a lette, otherwise return false


public class checkCharacter {
	public static boolean[] ascii = new boolean[256];
	
	public static void main(String[] args) 
	{
		// Faster method
		for (int i = 'a'; i <= 'z'; i++) {
			ascii[i] = true;
		}
		for (int i = 'A'; i <='Z'; i++) {
			ascii[i] = true;
		}
		System.out.println(ascii['a']);
		System.out.println(ascii['z']);
		System.out.println(ascii['A']);
		System.out.println(ascii['Z']);
		System.out.println(ascii['!']);
		System.out.println(ascii['*']);
		
		
		// First method
		// System.out.println(check('a'));
	}
	public static boolean check(char c)
	{
		if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z'))
		{
			return true;
		}
		else return false;
	}
}