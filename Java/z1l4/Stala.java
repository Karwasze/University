package com.wyrazenia;

/**
 * Klasa implementujaca stala Parametrem jest tutaj zmienna double.
 */
public class Stala extends Wyrazenie{
    final private double x;

    public Stala(double x)
    {
        this.x = x;
    }

    public double oblicz()
    {
        return x;
    }
}
