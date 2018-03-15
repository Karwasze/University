package com.wyrazenia;

import static java.lang.Math.*;

/**
 * Klasa implementujaca cosinus.
 */
public class Cosinus extends Operator1Arg{
    public Cosinus (Wyrazenie a1) {
        super(a1);
    }

    public double oblicz () {
        return cos(arg1.oblicz());
    }
    public String toString () {
        return "Cos("+arg1+")";
    }
}
