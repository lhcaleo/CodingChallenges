import java.util.*;
// https://open.kattis.com/problems/virus

public class virus_260711526
{
    public static void main(String[] args) 
    {
        // Read in two lines
        Scanner scanner = new Scanner(System.in);
        String in =  scanner.nextLine();
        String out = scanner.nextLine();
        scanner.close();
        
        int minLength = Math.min(in.length(), out.length());
        int sameFromStart = 0;
        int sameFromEnd = 0;
        
        // Strategy: erase same characters from both front and end
        // Find # of same characters from front
        for (int i = 0; i < minLength; i++) 
        {
            if(in.charAt(i) != out.charAt(i))
            {
                sameFromStart = i;
                break;
            } 
        }

        // Find # of same characters from end
        while (sameFromEnd < minLength && (in.charAt(in.length()-1-sameFromEnd) == out.charAt(out.length()-1-sameFromEnd)))
        {
            sameFromEnd++;
        }

        int result = out.length() - sameFromStart - sameFromEnd;
        result = Math.max(result,0);
        
        System.out.println(Math.max(result, out.length() - in.length()));
    }
}