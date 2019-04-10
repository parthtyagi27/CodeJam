
package solutions;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import lib.Writer;

public class Pancakes
{
    private static Writer writer;
    private static int solved = 0;
    
    public static void main(String[] args) throws IOException
    {
        Scanner input = new Scanner(new InputStreamReader(Pancakes.class.getResourceAsStream("/input/problem2large.in")));
        writer = new Writer("problem2large.out");
        int numberOfCases = input.nextInt();
        input.reset();
        input.close();
        Scanner input1 = new Scanner(new InputStreamReader(Pancakes.class.getResourceAsStream("/input/problem2large.in")));
        input1.nextLine();
        for(short i = 0; i < numberOfCases; i++)
        {
            String currentInput = input1.nextLine();
            solved++;
            solve(currentInput);
        }
        input1.close();
        writer.flush();
    }

    private static void solve(String currentInput) throws IOException
    {
        int flips = 0;
        char[] pancakes = currentInput.toCharArray();
        if(checkIfSolved(pancakes) == true)
        {
            writer.write("Case #" + solved + ": " + flips);
            System.out.println("Case #" + solved + ": " + flips);
        }
        else
        {
            while(checkIfSolved(pancakes) == false)
            {
                flipPancakes(getFirstPancake(pancakes), pancakes);
                flips++;
            }
            writer.write("Case #" + solved + ": " + flips);
            System.out.println("Case #" + solved + ": " + flips);
        }
    }
    
    private static boolean checkIfSolved(char[] pancakes)
    {
        for(int i = 0; i < pancakes.length; i++)
        {
            if(pancakes[i] != '+')
                return false;
        }
        return true;
    }
    
    private static char getFirstPancake(char[] pancakes)
    {
        return pancakes[0];
    }

    private static void flipPancakes(char firstPancake, char[] pancakes)
    {
        int lastIndex = getLastIndex(firstPancake, pancakes);
        for(int i = 0; i < lastIndex; i++)
        {
            if(pancakes[i] == '+')
                pancakes[i] = '-';
            else if(pancakes[i] == '-')
                pancakes[i] = '+';
        }
    }
    
    private static int getLastIndex(char n, char[] pancakes)
    {
        for(int i = 0; i < pancakes.length; i++)
        {
            if(pancakes[i] != n)
                return i;
        }
        return pancakes.length;
    }
}
