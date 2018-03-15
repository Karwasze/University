package com.geometria;

public class Punkt {
    private double x;
    private double y;

    public Punkt(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void przesun(Wektor v)
    {
        this.x = this.x += v.dx;
        this.y = this.y += v.dy;
    }

    public void obroc(Punkt p, double kat)
    {
        double tempx;
        tempx = (this.x - p.getX())*Math.cos(kat) - (this.y - p.getY()) * Math.sin(kat) + p.getX();
        this.y = (this.x - p.getX())*Math.sin(kat) - (this.y - p.getY()) * Math.cos(kat) + p.getY();
        this.x = tempx;
    }

    public void odbicie(Prosta p)
    {
        double x1, y1;
        x1 = ((1 - p.a*p.a)/(1+p.a*p.a))*this.x + ((2*p.a)/(1+p.a*p.a))*this.y;
        y1 = ((2*p.a)/(1+p.a*p.a))*this.x + ((1 - p.a*p.a)/(1+p.a*p.a))*this.y;
        this.x = x1;
        this.y = y1;
    }
}
