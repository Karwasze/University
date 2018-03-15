package com.geometria;

public class Prosta {
    public final double a, b, c;

    public Prosta(double a, double b, double c)
    {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public static Prosta przesun(Prosta p, Wektor v)
    {
        return new Prosta(p.a, p.b, p.c + v.dy * p.b + v.dx * p.a);
    }
    public static boolean rownolegle(Prosta p1, Prosta p2)
    {
        if(p1.a / -p1.b == p2.a / -p2.b)
        {
            return true;
        }
        else
            return false;
    }

    public static boolean prostopadle(Prosta p1, Prosta p2)
    {
        if(p1.a / -p1.b == -p2.a / p2.b)
        {
            return true;
        }
        else
            return false;
    }
    public static String przeciecie(Prosta p1, Prosta p2)
    {
        if(rownolegle(p1, p2))
        {
            System.err.println("Proste są równoległe");
            return "";
        }
        else
        {
            double w = (p1.a * p2.b) - (p2.a *p1.b);
            double wx = (-p1.c)*p2.b - (-p2.c)*p1.b;
            double wy = p1.a*(-p2.c) - p2.a*(-p1.c);
            double x = wx/w;
            double y = wy/w;
            return x + " " + y;
        }
    }
}
