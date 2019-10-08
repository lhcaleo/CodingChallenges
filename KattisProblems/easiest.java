import java.util.*;

public class easiest 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		// input is a list of integers 1 <= n <= 1000
		while(n != 0){
			System.out.println(findP(n));
			n = sc.nextInt();
		}
		sc.close();
	}
	// return the sum of digits of input n
	public static int sum(int n)
	{
		int sum = 0;
		while(n > 0)
		{
			sum += n%10;
			n /= 10;
		}
		return sum;
	}
	// return the desired integer p
	public static int findP(int n)
	{
		int p = 11;
		int product_sum = sum(n*p);
		int n_sum = sum(n);
		while (product_sum != n_sum) {
			p++;
			product_sum = sum(n*p);
			n_sum = sum(n);
		}
		return p;
	}
}