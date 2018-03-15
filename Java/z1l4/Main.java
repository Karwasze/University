package com.wyrazenia;

/**
 * Glowna klasa, zawiera testy z z zadania 4.
 */
public class Main {

    public static void main(String[] args) {
	Para para = new Para("a",12);
	System.out.println(para.toString());

	Para para1 = new Para("b", 13);
	Para para2 = new Para("b",14);
	Para para3 = new Para("c", 11);
	System.out.println(para.equals(para1));

	Zbior zbior = new Zbior();

	zbior.wstaw(para);
	zbior.wstaw(para1);
	System.out.println(zbior.ile());
	System.out.println(zbior.szukaj("a"));
	System.out.println(zbior.czytaj("b"));
	zbior.ustal(para2);
	System.out.println(zbior.szukaj("b"));
	zbior.ustal(para3);
	System.out.println(zbior.szukaj("c"));
	System.out.println(zbior.ile());
	zbior.czysc();
	System.out.println(zbior.ile());
	Wyrazenie w = new Dodaj(new Stala(7), new Mnoz(new Zmienna("j"), new Stala(5)));
	System.out.println(w.oblicz());

	//TESTY

	Wyrazenie w1 = new Dodaj(new Stala(3), new Stala(5));
	System.out.println("Wyrazenie 1 = " + w1.oblicz());

	Wyrazenie w2 = new Dodaj(new Mnoz(new Zmienna("y"), new Stala(7)),new Stala(2));
	System.out.println("Wyrazenie 2 = " + w2.oblicz());

	Wyrazenie w3 = new Dzielenie(
						new Odejmij(
								new Mnoz(
										new Stala(3),
										new Stala(11)
										),
								new Stala(1)
								),

						new Dodaj(
							new Stala(7),
							new Stala(5)
						)
						);
	System.out.println("Wyrazenie 3 = " + w3.oblicz());
	Wyrazenie w4 = new Arctan(
			new Dzielenie(
					new Mnoz(
							new Dodaj(
									new Zmienna("z"),
									new Stala(13)),
							new Zmienna("z")),
					new Stala(2)));

	System.out.println("Wyrazenie 4 = " + w4.oblicz());

	Wyrazenie w5 = new Dodaj(
							new Pow(
									new Stala(2),
									new Stala(5)),
							new Mnoz(
									new Zmienna("xx"),
									new Log(
											new Stala(2),
											new Zmienna("xy")
									)
							)

	);

	System.out.println("Wyrazenie 5 = " + w5.oblicz());
	}
}
