package com.wyrazenia;

/**
 * Klasa implementujaca operacje minimum. Podaje minimalny z dwoch argumentow.
 */

public class Min extends Operator2Arg
{
    public Min (Wyrazenie a1, Wyrazenie a2) {
        super(a1,a2);
    }

    public double oblicz () {
        if(arg1.oblicz() > arg2.oblicz())
            return arg2.oblicz();
        else
            return arg1.oblicz();
    }
    public String toString () {
        return "Min("+arg1+" , "+arg2+")";
    }
}
