package com.wyrazenia;

/**
 * Klasa implementujaca zbior.
 */

public class Zbior {

    Para [] tab = new Para[100];
    {
        for (int i = 0; i < 100; i++)
        {
            tab[i] = new Para();
        }
    }

    public Para szukaj (String kl)
    {
        for(int i = 0;i < 100; i++)
        {
            if(tab[i].klucz == kl)
            {
                return tab[i];
            }
        }
        return null;
    }

    public void wstaw (Para p) throws IllegalArgumentException
    {
        if (p.klucz == "")
        {
            System.err.println("Nie mozna dodac pary o podanym kluczu");
            return;
        }
        for(int i = 0; i < 100; i++)
        {
            if(tab[i].klucz == p.klucz)
            {
                System.out.println("Podany klucz istnieje w zbiorze");
                return;
            }
        }
        for(int i = 0; i < 100; i++)
        {
            if(tab[i].klucz == "")
            {
                tab[i] = p;
                return;
            }
        }
    }

    public double czytaj (String kl) throws IllegalArgumentException
    {
        for(int i = 0;i < 100; i++)
        {
            if(tab[i].klucz == kl)
            {
                return tab[i].getWartosc();
            }
        }
        return 0;
    }

    /** metoda wstawia do zbioru nowa albo aktualizuje istniejaca pare */
    public void ustal (Para p) throws IllegalArgumentException
    {
        for(int i = 0; i < 100; i++)
        {
            if(tab[i].klucz == p.klucz)
            {
                tab[i] = p;
                break;
            }
            if(tab[i].klucz == "")
            {
                tab[i] = p;
                break;
            }
        }
    }
    /** metoda podaje ile par jest przechowywanych w zbiorze */
    public int ile ()
    {
        int counter = 0;
        for (int i = 0; i < 100; i++)
        {
            if(tab[i].klucz != "")
                counter++;
        }
        return counter;
    }
    /** metoda usuwa wszystkie pary ze zbioru */
    public void czysc ()
    {
        for (int i = 0; i < 100; i++)
        {
            tab[i] = new Para();
        }
    }
}