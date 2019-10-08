import java.util.*;
// Idea: Using provided data structures to test directly
public class guessthedatastructure_260711526 {
	public static void main(String[] args) {
		// Use scanner to get input
		Scanner sc = new Scanner(System.in);
		// Input is terminated by end of file
		while(sc.hasNextInt())
		{
			// each of the next n lines has 2 ints
			int n = Integer.parseInt(sc.next());
			int command,x;
			Stack<Integer> stack = new Stack<>();
			Queue<Integer> queue = new LinkedList<>();
			PriorityQueue<Integer> pQueue = new PriorityQueue<>((a,b) -> (b-a));
			// int indicates if it's a stack,queue,pQueue
			int s,q,p;
			s = q = p = 1;
			for(int i = 0; i < n; i++)
			{
				// read 2 ints from one line
				command = Integer.parseInt(sc.next());
				x = Integer.parseInt(sc.next());
				// add
				if(command == 1)
				{
					stack.push(x);
					queue.add(x);
					pQueue.add(x);
				}
				// otherwise, remove
				else
				{
					if(s == 1)
					{
						if(stack.isEmpty() || stack.peek() != x)
						{
							s = 0;
						}
						else stack.pop();
					}
					if(q == 1)
					{
						if(queue.isEmpty() || queue.peek() != x)
						{
							q = 0;
						}
						else queue.remove();
					}
					if(p == 1)
					{
						if(pQueue.isEmpty() || pQueue.peek() != x)
						{
							p = 0;
						}
						else pQueue.remove();
					}
				}
			}
			if (s + q + p == 0) System.out.println("impossible");
			else if (s + q + p > 1) System.out.println("not sure");
			else if (s == 1) System.out.println("stack");
			else if (q == 1) System.out.println("queue");
			else if (p == 1) System.out.println("priority queue");
		}
		sc.close();
	}
}