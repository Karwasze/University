package com.wyrazenia;

/**
 * Klasa implementujaca logarytm. Oblicza wartosc logarytmu
 * z drugiego argumentu o podstawie rownej wartosci pierwszego argumentu.
 */
public class Log extends Operator2Arg
{
    public Log (Wyrazenie a1, Wyrazenie a2) {
        super(a1,a2);
    }

    public double oblicz () {
        return Math.log(arg2.oblicz())/Math.log(arg1.oblicz());
    }
    public String toString () {
        return "Log("+arg2+" , "+arg1+")";
    }
}
