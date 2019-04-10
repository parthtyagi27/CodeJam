
package solutions;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Bleatrix
{
    private static boolean digitsFound = false;
    private static final String out = "problem1small.out";
    private static int solved = 1;
    
    public static void main(String[] args) throws URISyntaxException, IOException
    {
        Scanner scan = new Scanner(new InputStreamReader(Bleatrix.class.getResourceAsStream("/input/problem1large.in")));

        int numberOfCases = scan.nextInt();
        scan.reset();
        for(short i = 0; i < numberOfCases; i++)
        {
            int input = scan.nextInt();
            solve(input);
            solved++;
        }
    }
    
    private static void solve(int n) throws IOException
    {
        if(n == 0)
        {
            System.out.println("Case #" + solved + ": INSOMNIA");
        }
        else
        {
            int cycle = 1;
            char[] digits = {'0','1','2','3','4','5','6','7','8','9'};
            while(digitsFound == false)
            {
                char[] nDigits = ((cycle * n) + "").toCharArray();
                checkForDigitOccurence(digits, nDigits);
                if(checkIfEmpty(digits) == true)
                    break;
                cycle++;
            }
            write((cycle * n));
        }
    }
    
    private static void checkForDigitOccurence(char[] digits, char[] nDigits)
    {
        for(int i = 0; i < digits.length; i++)
        {
            for(int j = 0; j < nDigits.length; j++)
            {
                if(digits[i] == nDigits[j])
                    digits[i] = 'p';
            }
        }
    }
    
    private static boolean checkIfEmpty(char[] digits)
    {
        for(int i = 0; i < digits.length; i++)
        {
            if(digits[i] != 'p')
                return false;
        }
        return true;
    }
    
    private static void write(int n) throws IOException
    {
        System.out.println("Case #" + solved + ": " + n);
    }
}
