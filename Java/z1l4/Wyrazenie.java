package com.wyrazenia;

/**
 * Klasa bazowa dla wyrazen.
 */

abstract class Wyrazenie {
    abstract double oblicz();
    public static double sumuj (Wyrazenie... wyr)
    {
        double wynik = 0;
        for (int i = 0; i <wyr.length; i++)
        {
            wynik += wyr[i].oblicz();
        }
        return wynik;
    }


    public static double pomnoz (Wyrazenie... wyr)
    {
        double wynik = 0;
        for (int i = 0; i <wyr.length; i++)
        {
            wynik *= wyr[i].oblicz();
        }
        return wynik;
    }

}

