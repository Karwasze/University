package com.geometria;

public class Trojkat {
    private Punkt punkt1;
    private Punkt punkt2;
    private Punkt punkt3;

    public Trojkat(Punkt punkt1, Punkt punkt2, Punkt punkt3)
    {
        double det = (punkt1.getX() * punkt2.getY()) + (punkt1.getY() * punkt3.getX()) +
                (punkt2.getX() * punkt3.getY()) - (punkt3.getX() * punkt2.getY()) -
                (punkt1.getX()*punkt3.getY()) - (punkt1.getY()*punkt2.getX());

        if(det != 0)
        {
            this.punkt1 = punkt1;
            this.punkt2 = punkt2;
            this.punkt3 = punkt3;
        }
        else
            System.err.println("Podane punkty są współliniowe");
    }

    public void przesun(Wektor v) {
        double x1 = this.punkt1.getX();
        double x2 = this.punkt2.getX();
        double y1 = this.punkt1.getY();
        double y2 = this.punkt2.getY();
        double x3 = this.punkt3.getX();
        double y3 = this.punkt3.getY();
        this.punkt1.setX(x1 += v.dx);
        this.punkt2.setX(x2 += v.dx);
        this.punkt1.setY(y1 += v.dy);
        this.punkt2.setY(y2 += v.dy);
        this.punkt3.setX(x3 += v.dx);
        this.punkt3.setY(y3 += v.dy);
    }

    public void obroc(Punkt p, double kat)
    {
        double x1 = (this.punkt1.getX() - p.getX())*Math.cos(kat) - (this.punkt1.getY() - p.getY()) * Math.sin(kat) + p.getX();
        double y1 = (this.punkt1.getX() - p.getX())*Math.sin(kat) - (this.punkt1.getY() - p.getY()) * Math.cos(kat) + p.getY();
        double x2 = (this.punkt2.getX() - p.getX())*Math.cos(kat) - (this.punkt2.getY() - p.getY()) * Math.sin(kat) + p.getX();
        double y2 = (this.punkt2.getX() - p.getX())*Math.sin(kat) - (this.punkt2.getY() - p.getY()) * Math.cos(kat) + p.getY();
        double x3 = (this.punkt3.getX() - p.getX())*Math.cos(kat) - (this.punkt3.getY() - p.getY()) * Math.sin(kat) + p.getX();
        double y3 = (this.punkt3.getX() - p.getX())*Math.sin(kat) - (this.punkt3.getY() - p.getY()) * Math.cos(kat) + p.getY();
        this.punkt1.setX(x1);
        this.punkt2.setY(y2);
        this.punkt1.setX(x2);
        this.punkt2.setY(y2);
        this.punkt3.setX(x3);
        this.punkt3.setY(y3);
    }

    public void odbicie(Prosta p)
    {
        double x1, y1, x2, y2, x3, y3;
        x1 = ((1 - p.a*p.a)/(1+p.a*p.a))*this.getX1() + ((2*p.a)/(1+p.a*p.a))*this.getY1();
        y1 = ((2*p.a)/(1+p.a*p.a))*this.getX1() + ((1 - p.a*p.a)/(1+p.a*p.a))*this.getY1();
        x2 = ((1 - p.a*p.a)/(1+p.a*p.a))*this.getX2() + ((2*p.a)/(1+p.a*p.a))*this.getY2();
        y2 = ((2*p.a)/(1+p.a*p.a))*this.getX2() + ((1 - p.a*p.a)/(1+p.a*p.a))*this.getY2();
        x3 = ((1 - p.a*p.a)/(1+p.a*p.a))*this.getX3() + ((2*p.a)/(1+p.a*p.a))*this.getY3();
        y3 = ((2*p.a)/(1+p.a*p.a))*this.getX3() + ((1 - p.a*p.a)/(1+p.a*p.a))*this.getY3();
        this.punkt1.setX(x1);
        this.punkt1.setY(y1);
        this.punkt2.setX(x2);
        this.punkt2.setY(y2);
        this.punkt3.setX(x3);
        this.punkt3.setY(y3);
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

    public double getX3()
    {
        return punkt3.getX();
    }

    public double getY3()
    {
        return punkt3.getY();
    }
}
