
package solutions;

import java.math.BigInteger;
import java.util.ArrayList;

public class JamcoinsLarge
{
    public static void main(String[] args)
    {
        int i = 32, j = 500;
        solve(i, j);
    }

    private static void solve(int i, int j)
    {
        BigInteger min = findMinBound(i);
        BigInteger max = findMaxBound(i);
        ArrayList<BigInteger> coins = createCoins(min, max);
        findTrivialFactors(coins);
    }

    private static BigInteger findMinBound(int i)
    {
        String n = "1";
        for(short k = 0; k < (i - 1); k++)
        {
            n += "0";
        }
        BigInteger minBound = new BigInteger(n, 2);
        return minBound;
    }

    private static BigInteger findMaxBound(int i)
    {
        String n = "1";
        for(short k = 0; k < (i - 1); k++)
        {
            n += "1";
        }
        BigInteger maxBound = new BigInteger(n, 2);
        return maxBound;
    }

    private static ArrayList<BigInteger> createCoins(BigInteger min, BigInteger max)
    {
        ArrayList<BigInteger> coins = new ArrayList<>();
        for(BigInteger i = new BigInteger(min.toString()); i.compareTo(max) <= -1; i.add(BigInteger.ONE))
        {
            BigInteger possibility = new BigInteger(min.toString(2));
            min = min.add(BigInteger.ONE);
            if(possibility.toString().endsWith("1") && possibility.isProbablePrime(-1) == true)
                coins.add(possibility);
            if(coins.size() > 500)
                break;
        }
        return coins;
        
    }
    
    private static void findTrivialFactors(ArrayList<BigInteger> coins)
    {
        String divisors = "";
        for(int i = 0; i < coins.size(); i++)
        {
            for(int k = 2; k <= 10; k++)
            {
                BigInteger number = new BigInteger(coins.get(i).toString(k));
                System.out.println("Finding non-trivial divisors of: " + number);
                for(BigInteger z = new BigInteger("2"); z.compareTo(number.divide(new BigInteger("2"))) <= 0; z = z.add(BigInteger.ONE))
                {
                    
                    if(number.remainder(z) == BigInteger.ZERO)
                    {
                        divisors += z + " ";
                        break;
                    }
                        
                }
                    
            }
            System.out.println(coins.get(i).toString() + " " + divisors);
            divisors = "";
        }
    }
}
