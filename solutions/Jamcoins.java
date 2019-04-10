
package solutions;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;
import lib.Writer;

public class Jamcoins
{
    private static Writer writer;
    
    public static void main(String[] args) throws IOException
    {
        Scanner number = new Scanner(Jamcoins.class.getResourceAsStream("/input/problem3small.in"));
        number.nextInt();
        //solve(number.nextInt(), number.nextInt());
        writer = new Writer("problem3small.out");
        writer.write("Case #1:");
        solve(32, 500);
        number.close();
        writer.flush();
    }

    private static void solve(int n, int j) throws IOException
    {
        ArrayList<String> coins = createJamCoin(n);
        for(int i = 0; i < j; i++)
        {
            writer.write(coins.get(i) + " " + getTrivialDivisors(coins.get(i)));
        }
    }
    
    private static ArrayList<String> createJamCoin(int n)
    {
        ArrayList<String> possibleCoins = new ArrayList<>();
        String min = "1", max = "1";
        long minBound, maxBound;
        
        for(int i = 0; i < n - 1; i++)
        {
            min += "0";
            max += "1";
        }
        minBound = convertToBase(2, min);
        maxBound = convertToBase(2, max);

        for(int i = (int) minBound; i <= maxBound; i++)
        {
            String possibility = convertToNumber(2, (int) minBound++);
            if(possibility.endsWith("1") && checkForPrimes(possibility) == true)
            {
                possibleCoins.add(possibility);
                if(possibleCoins.size() >= 500)
                    break;
            }
        }
        return possibleCoins;
    }
    
    private static boolean checkForPrimes(String possibility)
    {
        for(int i = 2; i <= 10; i++)
        {
            if(isPrime(convertToBase(i, possibility)) == true)
                return false;
        }
        return true;
    }
    
    private static long convertToBase(int base, String n)
    {
        long num = 0;
        char[] digits = n.toCharArray();
        for(int i = 0; i < digits.length; i++)
        {
            num = num + Long.parseLong(Character.toString(digits[i]));
            if(i != (digits.length - 1))
                num = num * base;
        }
        return num;

    }
    
    private static String convertToNumber(int base, int n)
    {
        String digits = "";
        ArrayList<Integer> array = new ArrayList<> ();
        
        while(n != 0)
        {
            array.add(n % base);
            n = n / base;
        }
        for(int i = array.size() - 1; i >= 0; i--)
        {
            digits += array.get(i) + "";
        }
        return digits;
    }
    
    private static boolean isPrime(long n)
    {
        if(n == 2 || n == 3)
            return true;
        if(n % 2 == 0 || n % 3 == 0 || n == 0 || n == 1)
            return false;
        
        int divisorUpperBound = (int) Math.ceil(Math.sqrt(n));
        for(int i = divisorUpperBound; i > 3; i--)
        {
            if(n % i == 0)
                return false;
        }
        return true;
    }
    
    private static String getTrivialDivisors(String coin)
    {
        String divisors = "";
        for(int i = 2; i <= 10; i++)
        {
            long number = convertToBase(i, coin);
            for(int j = 2; j <= Math.ceil(Math.sqrt(number)); j++)
            {
                if(number % j == 0)
                {
                    divisors += j + " ";
                    System.out.println(coin + " in base " + i + " is: " + number + " and is divisble by: " + j);
                    break;
                }
            }
        }
        return divisors;
    }
    
}
