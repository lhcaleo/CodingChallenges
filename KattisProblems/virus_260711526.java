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
        while (sameFromEnd < minLength && (in.charAt(in.length()-1-sameFromEnd) == out.charAt(out.length()-1-sameFromEnd)))
        {
            sameFromEnd++;
        }

        
        int result = out.length() - sameFromStart - sameFromEnd;
        result = Math.max(result,0); // if result > 0 , same. If result <=0 result = 0
        // return > 0 return 
        
        System.out.println(Math.max(result, out.length() -in.length()));
        
        
//        if(result > 0)
//        {
//            System.out.println(result);
//        }
//        // if all the characters in second string are erased, 
//        // just find the # of characters left in first string
//        else System.out.println(Math.abs(in.length() - out.length()));
        
    }

}