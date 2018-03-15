package com.geometria;


public class Main {

    public static void main(String[] args) {
	Punkt punkt = new Punkt(1,0);
	Punkt punkt1 = new Punkt(-2,-1);
	Punkt punkt2 = new Punkt(-5,12);
	Punkt punkt3 = new Punkt(0,0);
	Punkt punkt4 = new Punkt(1,0);
	Punkt blednypunkt = new Punkt(0,0);
	Wektor v = new Wektor(1,2);
	System.out.println(punkt.getX() +" " +punkt.getY());
	Odcinek odcinek = new Odcinek(punkt,punkt1);
	System.out.println(odcinek.getX1() + " " + odcinek.getY1() + " " + odcinek.getX2() + " " + odcinek.getY2());
	Odcinek bledny = new Odcinek(blednypunkt, blednypunkt);
	Trojkat trojkat = new Trojkat(punkt, punkt1, punkt2);
	Trojkat blednytrojkat = new Trojkat(punkt1,punkt,punkt1);
	System.out.println(trojkat.getX1() + " " + trojkat.getY1() + " " + trojkat.getX2() + " " + trojkat.getY2() + " " +
            trojkat.getX3() + " " + trojkat.getY3());
	punkt.przesun(v);
	System.out.println(punkt.getX() +" " +punkt.getY());
	System.out.println(odcinek.getX1() + " " + odcinek.getY1() + " " + odcinek.getX2() + " " + odcinek.getY2());
	odcinek.przesun(v);
	System.out.println(odcinek.getX1() + " " + odcinek.getY1() + " " + odcinek.getX2() + " " + odcinek.getY2());
	System.out.println(trojkat.getX1() + " " + trojkat.getY1() + " " + trojkat.getX2() + " " + trojkat.getY2() + " " +
                trojkat.getX3() + " " + trojkat.getY3());
	trojkat.przesun(v);
	System.out.println(trojkat.getX1() + " " + trojkat.getY1() + " " + trojkat.getX2() + " " + trojkat.getY2() + " " +
                trojkat.getX3() + " " + trojkat.getY3());
	System.out.println(punkt.getX() +" " +punkt.getY());

	punkt.obroc(punkt3,Math.PI);
	System.out.println(punkt.getX() +" " +punkt.getY());
	Prosta p = new Prosta(1,1,4);
    Prosta p1 = new Prosta(4,7,1);
    System.out.println(Prosta.rownolegle(p,p1));
    Prosta p2 = new Prosta(2,1,3);
    System.out.println(Prosta.przeciecie(p,p1));

    punkt4.obroc(punkt3,Math.PI);

    System.out.println(punkt4.getX() + " " + punkt4.getY());
    }
}
