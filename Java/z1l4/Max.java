package com.wyrazenia;

/**
 * Klasa implementujaca operacje maksimum. Podaje najwiekszy z dwoch argumentow.
 */

public class Max extends Operator2Arg
{
    public Max (Wyrazenie a1, Wyrazenie a2) {
        super(a1,a2);
    }

    public double oblicz () {
        if(arg1.oblicz() > arg2.oblicz())
            return arg1.oblicz();
        else
            return arg2.oblicz();
    }
    public String toString () {
        return "Max("+arg1+" , "+arg2+")";
    }
}
