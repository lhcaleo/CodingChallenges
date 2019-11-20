// https://open.kattis.com/problems/grid
// Tree + DFS
import java.util.*;

public class grid
{
	// rows and columns of the grid
	public static int R, C;
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		int[][] grid = new int[R][C];
		int[][] depth = new int[R][C];
		for (int i = 0; i < R; i++) 
		{
			String line = sc.next();
			for(int j = 0; j < C; j++)
			{
				grid[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
				depth[i][j] = -1;
			}
		}
		depth[0][0] = 0;
		
		Pair start = new Pair(0,0);
		ArrayList<Pair> list = new ArrayList<>();
		list.add(start);
		// use left-top corner as root
		// search with BFS
		while (!list.isEmpty()) 
		{
			Pair curr = list.remove(0);
			int row = curr.row;
			int col = curr.col;
			int jump = grid[row][col];
//			System.out.println("----------------");
//			System.out.println("curr: " + row + "," + col + " jump = " + jump + " depth:" + depth[row][col] );

			// check up jump
			if(inGrid(row - jump, col) && depth[row - jump][col] == -1)
			{
//				System.out.println("up to " + (row-jump) + "," + col);
				list.add(new Pair(row - jump, col));
				depth[row - jump][col] = depth[row][col] + 1;
			}
			// check down jump
			if(inGrid(row + jump, col) && depth[row + jump][col] == -1)
			{
//				System.out.println("down to " + (row+jump) + "," + col);
				list.add(new Pair(row + jump, col));
				depth[row + jump][col] = depth[row][col] + 1;
			}
			// checl left jump
			if(inGrid(row, col - jump) && depth[row][col - jump] == -1)
			{
//				System.out.println("left to " + row + "," + (col-jump));
				list.add(new Pair(row, col - jump));
				depth[row][col - jump] = depth[row][col] + 1;
			}
			// check right jump
			if(inGrid(row, col + jump) && depth[row][col + jump] == -1)
			{
//				System.out.println("right to " + row + "," + (col+jump));
				list.add(new Pair(row, col + jump));
				depth[row][col + jump] = depth[row][col] + 1;
			}
//			System.out.println("----------------");
		}
		// The number of moves to right-bottom corner is the depth of this x,y pair.
		System.out.println(depth[R-1][C-1]);
	}
	
	// check if the Pair is inside the Grid
	private static boolean inGrid(int row, int col)
	{
		return 0 <= row && row < R && 0 <= col && col < C;
	}
}

// Pair (row,col) with row and column index
class Pair
{
	public int row, col;
	public Pair(int r, int c)
	{
		row = r;
		col = c;
	}
}