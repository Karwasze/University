package com.wyrazenia;

import static java.lang.Math.*;

/**
 * Klasa implementujaca operator jednoargumentowy sinus.
 */
public class Sinus extends Operator1Arg{
    public Sinus (Wyrazenie a1) {
        super(a1);
    }

    public double oblicz () {
        return sin(arg1.oblicz());
    }
    public String toString () {
        return "Sin("+arg1+")";
    }
}
