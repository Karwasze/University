package com.geometria;

public class Odcinek {
    private Punkt punkt1;
    private Punkt punkt2;

    public Odcinek(Punkt punkt1, Punkt punkt2)
    {
        if((punkt1.getX() != punkt2.getX()) && punkt1.getY() != punkt2.getY())
        {
            this.punkt1 = punkt1;
            this.punkt2 = punkt2;
        }
        else
            System.err.println("Podano złe współrzędne");
    }

    public void przesun(Wektor v)
    {
        double x1 = this.punkt1.getX();
        double x2 = this.punkt2.getX();
        double y1 = this.punkt1.getY();
        double y2 = this.punkt2.getY();
        this.punkt1.setX(x1 += v.dx);
        this.punkt2.setX(x2 += v.dx);
        this.punkt1.setY(y1 += v.dy);
        this.punkt2.setY(y2 += v.dy);
    }

    public void obroc(Punkt p, double kat)
    {
        double x1 = (this.punkt1.getX() - p.getX())*Math.cos(kat) - (this.punkt1.getY() - p.getY()) * Math.sin(kat) + p.getX();
        double y1 = (this.punkt1.getX() - p.getX())*Math.sin(kat) - (this.punkt1.getY() - p.getY()) * Math.cos(kat) + p.getY();
        double x2 = (this.punkt2.getX() - p.getX())*Math.cos(kat) - (this.punkt2.getY() - p.getY()) * Math.sin(kat) + p.getX();
        double y2 = (this.punkt2.getX() - p.getX())*Math.sin(kat) - (this.punkt2.getY() - p.getY()) * Math.cos(kat) + p.getY();
        this.punkt1.setX(x1);
        this.punkt2.setY(y2);
        this.punkt1.setX(x2);
        this.punkt2.setY(y2);
    }

    public void odbicie(Prosta p)
    {
        double x1, y1, x2, y2;
        x1 = ((1 - p.a*p.a)/(1+p.a*p.a))*this.getX1() + ((2*p.a)/(1+p.a*p.a))*this.getY1();
        y1 = ((2*p.a)/(1+p.a*p.a))*this.getX1() + ((1 - p.a*p.a)/(1+p.a*p.a))*this.getY1();
        x2 = ((1 - p.a*p.a)/(1+p.a*p.a))*this.getX2() + ((2*p.a)/(1+p.a*p.a))*this.getY2();
        y2 = ((2*p.a)/(1+p.a*p.a))*this.getX2() + ((1 - p.a*p.a)/(1+p.a*p.a))*this.getY2();
        this.punkt1.setX(x1);
        this.punkt1.setY(y1);
        this.punkt2.setX(x2);
        this.punkt2.setY(y2);
    }

    public double getX1()
    {
        return punkt1.getX();
    }

    public double getX2()
    {
        return punkt2.getX();
    }

    public double getY1()
    {
        return punkt1.getY();
    }

    public double getY2()
    {
        return punkt2.getY();
    }

}
