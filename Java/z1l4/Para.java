package com.wyrazenia;

/**
 * Klasa implementujaca pare klucz-wartosc.
 */

public class Para {
    public final String klucz;
    private double wartosc;

    public Para()
    {
        this.klucz = "";
        this.wartosc = 0;
    }

    public Para(String klucz, double wartosc)
    {
        this.klucz = klucz;
        this.wartosc = wartosc;
    }
    public double getWartosc() {
        return wartosc;
    }

    public void setWartosc(double wartosc) {
        this.wartosc = wartosc;
    }

    public String toString() {
        return klucz + " " + wartosc;
    }

    public boolean equals(Para para) {
        if(this == null)
            return false;
        if(this.wartosc == para.getWartosc())
            return true;
        else
            return false;

    }
}
