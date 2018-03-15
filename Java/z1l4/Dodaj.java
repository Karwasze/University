package com.wyrazenia;

/**
 * Klasa implementujaca dodawanie.
 */

public class Dodaj extends Operator2Arg
{
    public Dodaj (Wyrazenie a1, Wyrazenie a2) {
        super(a1,a2);
    }

    public double oblicz () {
        return arg1.oblicz()+arg2.oblicz();
    }
    public String toString () {
        return "("+arg1+" + "+arg2+")";
    }
}
