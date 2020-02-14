// https://open.kattis.com/problems/natrij
import java.util.*;

public class natrij {
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		String line_1 = scanner.nextLine();
		String line_2 = scanner.nextLine();
//		System.out.println(line_1);
//		System.out.println(line_2);
		scanner.close();
		
		int hour_1 = Integer.parseInt(line_1.substring(0, 2));
		int min_1 = Integer.parseInt(line_1.substring(3, 5));
		int sec_1 = Integer.parseInt(line_1.substring(6));
		//System.out.println(hour_1 + " " + min_1 + " " + sec_1);
		
		int hour_2 = Integer.parseInt(line_2.substring(0, 2));
		int min_2 = Integer.parseInt(line_2.substring(3, 5));
		int sec_2 = Integer.parseInt(line_2.substring(6));
		//System.out.println(hour_2 + " " + min_2 + " " + sec_2);
		
		// convert time in seconds
		int startTime = hour_1 * 3600 + min_1 * 60 + sec_1;
		int endTime = hour_2 * 3600 + min_2 * 60 + sec_2;
		
//		System.out.println(startTime+"s");
//		System.out.println(endTime+"s");
		
		// 24 hours
		if(startTime == endTime) 
		{
			System.out.println("24:00:00");
			return;
		}
		if(endTime < startTime)
		{
			endTime = endTime + 24*60*60;
		}
		
		// computer result time
		int diff = endTime - startTime;
		
		int sec = diff % 60;
		diff = diff - sec;
		
		int min = diff % (60*60) / 60;
		diff = diff - min*60;
		
		int hour = diff / 3600;
		
		String result = String.format("%02d:%02d:%02d", hour % 24, min % 60, sec % 60);
		System.out.println(result);

	}
}