package com.company;

import java.lang.*;

public final class LiczbyPierwsze
{
    private final static int POTEGA2 = 21 ;
    private final static int[] SITO = new int[1<<POTEGA2];
    static {
        SITO[1] = 1;
        for(int i = 2; i < 1<<POTEGA2;i++)
            SITO[i] = i;

        for(int i = 4; i < 1<<POTEGA2; i +=2)
            SITO[i] = 2;

        for(int i = 3; i * i < 1<<POTEGA2;i++)
            if (SITO[i] == i)
            {
                for (int j = i * i; j < 1 << POTEGA2; j += i)
                {
                    if (SITO[j] == j)
                        SITO[j] = i;
                }
            }
    }
    public static boolean czyPierwsza (long x)
    {
        for(long i = 2; i <= Math.sqrt(x);i++)
        {
            if(x%i == 0)
                return false;
        }
        return true;
    }
    public static long[] naCzynnikiPierwsze (long x)
    {
        long[] czynniki = new long[10000];
        int iterator = 0;
        if(x > 2<<POTEGA2)
        {
            for(long i = 2 ; i <= Math.sqrt(x); i++)
            {
                while(x % i == 0)
                {
                    x /= i;
                    czynniki[iterator] = i;
                    iterator++;
                }
            }
            iterator++;
            czynniki[iterator] = x;
            return czynniki;
        }
        while (x != 1)
        {
            czynniki[iterator] = SITO[(int)x];
            iterator++;
            x = x / SITO[(int)x];
        }

        return czynniki;
    }

    public static void main(String args[])
    {
        for(int i = 0;i<args.length;i++)
        {
            long x = new Long(args[i]);
            if(x == 0 || x == 1 || x == -1)
                System.out.println("Brak rozkładu");

            if (x > 1)
            {
                if (czyPierwsza(x))
                {
                    System.out.println(x + " = 1 * " + x);
                }
                else
                {
                    long[] tablica = naCzynnikiPierwsze(x);
                    System.out.print(x + " = 1");
                    for (int j = 0; j < tablica.length; j++)
                    {
                        if (tablica[j] != 0)
                            System.out.print(" * " + tablica[j]);
                    }
                    System.out.println();
                }
            }
            if (x < -1 && (x != -9223372036854775808L))
            {
                x = -x;
                if (czyPierwsza(x))
                {
                    System.out.println(-x + " = -1 * " + x);
                }
                else
                {
                    long[] tablica = naCzynnikiPierwsze(x);
                    System.out.print(-x + " = -1");
                    for (int j = 0; j < tablica.length; j++)
                    {
                        if (tablica[j] != 0)
                            System.out.print(" * " + tablica[j]);
                    }
                    System.out.println();
                }
            }
            else
            {
                System.out.print(x + " = -1");
                for (int j = 0; j < 63; j++)
                {
                    System.out.print(" * " + 2);
                }
                System.out.println();
            }
        }
    }

}