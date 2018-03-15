package com.wyrazenia;

/**
 * Abstrakcyjna klasa bedacaca wezlem w drzewie wyrazen, przyjmuje jako argument jedno wyrazenie.
 */

public abstract class Operator1Arg extends Wyrazenie
{
    protected final Wyrazenie arg1;

    public Operator1Arg (Wyrazenie a1) {
        if (a1==null) throw new IllegalArgumentException();
        arg1 = a1;
    }
}
