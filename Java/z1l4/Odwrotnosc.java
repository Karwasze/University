package com.wyrazenia;

/**
 * Klasa implementujaca operator jednoargumentowy.
 */

public class Odwrotnosc extends Operator1Arg{
    public Odwrotnosc (Wyrazenie a1) {
        super(a1);
    }

    public double oblicz () {
        return (1/arg1.oblicz());
    }
    public String toString () {
        return "1/"+arg1;
    }
}
