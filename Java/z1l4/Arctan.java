package com.wyrazenia;

import static java.lang.Math.*;

/**
 * Klasa implementujaca arcus tangens.
 */
public class Arctan extends Operator1Arg{
    public Arctan (Wyrazenie a1) {
        super(a1);
    }

    public double oblicz () {
        return atan(arg1.oblicz());
    }
    public String toString () {
        return "Arctan("+arg1+")";
    }
}
