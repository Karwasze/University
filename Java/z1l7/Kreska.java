package com.grafika;

import java.awt.*;

public class Kreska
{
    protected Point poczatek, koniec;
    public final Color kolor;
    public Kreska (Point pocz, Point kon, Color kol)
    {
        this.poczatek = pocz;
        this.koniec = kon;
        this.kolor = kol;
    }
}