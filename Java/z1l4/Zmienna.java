package com.wyrazenia;

/**
 * Klasa implementujaca zmienne dla wyrazen.
 */

public class Zmienna extends Wyrazenie {

    final static Zbior zmienne = new Zbior();
    private String x;
    private double wart = -1.618;
    public Zmienna(String x)
    {
        this.x = x;
        zmienne.wstaw(new Para(this.x,wart));
    }
    public double oblicz()
    {
        return zmienne.czytaj(this.x);
    }

}
