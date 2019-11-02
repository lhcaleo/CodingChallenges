// https://open.kattis.com/problems/8queens
import java.util.*;

public class queens 
{
	// define queen
	public static char queen = '*';
	
	public static void main(String[] args) 
	{
		// ceate a 8x8 board to indicate whether attack-able or not
		// intially 0 means not attacked
		char[][] board = new char[8][8];
		Scanner scanner = new Scanner(System.in);
		
		// store the input into a 8x8 array
		for(int i = 0; i < 8; i++)
		{
			String str = scanner.nextLine();
			for(int j = 0; j < 8; j++)
			{
				board[i][j] = str.charAt(j);
			}
		}
		// iterate the board, row by row, char by char
		for (int i = 0; i < 8; i++) 
		{
			boolean valid = false;
			for (int j = 0; j < 8; j++) 
			{
				if(board[i][j] == queen)
				{
					valid = check(i, j, board);
				}
			}
			if(!valid)
			{
				System.out.println("invalid");
				return;
			}
		}
		// if no invalid is detected, return valid
		System.out.println("valid");
	}
	
	public static boolean check(int row, int col, char[][] board)
	{
		// detect other queens on the row
		for(int i = 0; i < 8; i++)
		{
			if(board[row][i] == queen && i != col) return false;
		}
		// column
		for(int i = 0; i < 8; i++)
		{ 
			if(board[i][col] == queen && i != row) return false;
		}

		// left up
		for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
		{
			if(i < 0 || j < 0) break;
			if(board[i][j] == queen) return false;
		}
		// left down
		for(int i = row + 1, j = col - 1; i >= 0 && j >= 0; i++, j--)
		{
			if(i < 0 || j < 8) break;
			if(board[i][j] == queen) return false;
		}
		// right up
		for(int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++)
		{
			if(i < 0 || j >= 8) break;
			if(board[i][j] == queen) return false;
		}
		// right down
		for(int i = row + 1, j = col + 1; i < 8 && j < 8; i++, j++)
		{
			if(i >= 8 || j >= 8) break;
			if(board[i][j] == queen) return false;
		}
		// else return true
		return true;
	}

}


