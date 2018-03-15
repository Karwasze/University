package com.wyrazenia;



import static java.lang.Math.*;
/**
 * Klasa implementujaca potegowanie. Podnosi wyrazenie do danej potegi.
 */
public class Pow extends Operator2Arg
{
    public Pow (Wyrazenie a1, Wyrazenie a2) {
        super(a1,a2);
    }

    public double oblicz () {
        return pow(arg1.oblicz(),arg2.oblicz());
    }
    public String toString () {
        return "("+arg1+" ^ "+arg2+")";
    }
}
