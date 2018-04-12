using System;
using System.Diagnostics;

namespace ProjektPO
{
    class MainClass
    {
        public static void Walka(Gracz gracz, Wrog wrog)
        {
            Console.WriteLine();
            Console.WriteLine("Walczysz z: " + wrog.nazwa);
            Console.WriteLine("Wybierz opcję: ");
            Console.WriteLine("Atak");
            Console.WriteLine("Magia");
            Console.WriteLine("Poddaj się");
            Console.WriteLine();
            gracz.tatak = gracz.atak;
            gracz.tobrona = gracz.obrona;
            while (gracz.tobrona > 0 && wrog.obrona > 0)
            {
                string input = Console.ReadLine();
                if (input == "poddaj sie")
                {
                    return;
                }
                gracz.Atak(input, wrog);
                if (wrog.obrona > 0)
                    wrog.Atak(gracz);
                else
                    break;
            }
            if(wrog.obrona > 0)
            {
                Console.WriteLine();
                Console.WriteLine("PRZEGRAŁEŚ");
                Console.WriteLine();
            }
            else
            {
                Console.WriteLine();
                Console.WriteLine("WYGRAŁEŚ");
                Console.WriteLine();
            }

        }
        public static void Main(string[] args)
        {
            Labirynt labirynt = new Labirynt(3, 3);
            labirynt.tab[1, 2].w = 2;
            labirynt.tab[1, 2].e = 2;
            labirynt.tab[1, 2].n = 1;

            labirynt.tab[0, 2].e = 2;
            labirynt.tab[0, 2].klucz = new Klucz(1, 2, 'n');

            labirynt.tab[2, 2].w = 2;
            labirynt.tab[2, 2].skarb = new Skarb();

            labirynt.tab[1, 1].s = 2;


            labirynt.tab[1, 2].wrog = new Wrog("Złodziej", 100);
            labirynt.tab[1, 1].e = 2;
            labirynt.tab[1, 2].przedmiot = new Przedmiot();
            labirynt.tab[1, 0].koniec = true;
            labirynt.tab[2, 1].klucz = new Klucz(1, 1, 'n');
            labirynt.tab[2, 1].w = 2;
            Console.WriteLine("LABIRYNT");
            Console.WriteLine();
            Console.WriteLine("Wpisz \"help\" aby uzyskać listę komend");
            Gracz gracz = new Gracz(1, 2);

            while (true)
            {
                string input = Console.ReadLine();

                if (input == "n")
                {
                    if (labirynt.tab[gracz.x, gracz.y].n == 2)
                    {
                        gracz.y -= 1;
                        Console.WriteLine();
                        Console.WriteLine("Pozycja gracza " + gracz.x + " " + gracz.y);
                        Console.WriteLine();
                    }
                    else
                    {
                        Console.WriteLine();
						Console.WriteLine("Nie możesz poruszyć się w tym kierunku");
                        Console.WriteLine();
                    }

                }

                if (input == "s")
                {
                    if (labirynt.tab[gracz.x, gracz.y].s == 2)
                    {
                        gracz.y += 1;
                        Console.WriteLine("Pozycja gracza " + gracz.x + " " + gracz.y);
                    }
                    else Console.WriteLine("Nie możesz poruszyć się w tym kierunku");
                }

                if (input == "w")
                {
                    if (labirynt.tab[gracz.x, gracz.y].w == 2)
                    {
                        gracz.x -= 1;
                        Console.WriteLine();
                        Console.WriteLine("Pozycja gracza " + gracz.x + " " + gracz.y);
                        Console.WriteLine();
                    }
                    else
                    {
                        Console.WriteLine();
						Console.WriteLine("Nie możesz poruszyć się w tym kierunku");
                        Console.WriteLine();
                    }
                }

                if (input == "e")
                {
                    if (labirynt.tab[gracz.x, gracz.y].e == 2)
                    {
                        gracz.x += 1;
                        Console.WriteLine();
                        Console.WriteLine("Pozycja gracza " + gracz.x + " " + gracz.y);
                        Console.WriteLine();
                    }
                    else
                    {
                        Console.WriteLine();
						Console.WriteLine("Nie możesz poruszyć się w tym kierunku");                  
                        Console.WriteLine();
                    }
                }
                if (input == "rozejrzyj")
                {
                    Console.WriteLine();
                    Console.WriteLine("W komnacie znajduje się: ");
                    Console.WriteLine();
                    if (labirynt.tab[gracz.x, gracz.y].n == 2)
                    {
                        Console.WriteLine("Przejście na północ ");
					}
                    if (labirynt.tab[gracz.x, gracz.y].s == 2)
                    {
						Console.WriteLine("Przejście na południe ");
                    }
                    if (labirynt.tab[gracz.x, gracz.y].w == 2)
                    {
						Console.WriteLine("Przejście na zachód ");                
                    }
                    if (labirynt.tab[gracz.x, gracz.y].e == 2)
                    {
						Console.WriteLine("Przejście na wschód ");
                    }
                    if (labirynt.tab[gracz.x, gracz.y].klucz != null)
                    {
						Console.WriteLine("Klucz ");
                    }
                    if (labirynt.tab[gracz.x, gracz.y].skarb != null)
                    {
						Console.WriteLine("Skarb ");
                    }
                    if (labirynt.tab[gracz.x, gracz.y].wrog != null)
                    {
						Console.WriteLine("Wróg ");
                    }
                    if (labirynt.tab[gracz.x, gracz.y].przedmiot != null)
                    {
						Console.WriteLine("Przedmiot ");
                    }
                }
                if (input == "podnies klucz")
                {
                    if (labirynt.tab[gracz.x, gracz.y].klucz != null)
                    {
                        Klucz klucz = labirynt.tab[gracz.x, gracz.y].klucz;
                        if (klucz.kier == 'n')
                        {
                            Console.WriteLine();
                            Console.WriteLine("Północne drzwi na polu: " + klucz.x + " " + klucz.y + " zostały odblokowane");
                            Console.WriteLine();
                            labirynt.tab[klucz.x, klucz.y].n = 2;
                            labirynt.tab[klucz.x, klucz.y - 1].s = 2;
                        }
                        if (klucz.kier == 's')
                        {
                            Console.WriteLine();
                            Console.WriteLine("Południowe drzwi na polu: " + klucz.x + " " + klucz.y + " zostały odblokowane");
                            Console.WriteLine();
                            labirynt.tab[klucz.x, klucz.y].s = 2;
                            labirynt.tab[klucz.x, klucz.y + 1].n = 2;
                        }

                        if (klucz.kier == 'w')
                        {
                            Console.WriteLine();
                            Console.WriteLine("Zachodnie drzwi na polu: " + klucz.x + " " + klucz.y + " zostały odblokowane");
                            Console.WriteLine();
                            labirynt.tab[klucz.x, klucz.y].w = 2;
                            labirynt.tab[klucz.x - 1, klucz.y].e = 2;
                        }

                        if (klucz.kier == 'e')
                        {
                            Console.WriteLine();
                            Console.WriteLine("Wschodnie drzwi na polu: " + klucz.x + " " + klucz.y + " zostały odblokowane");
                            Console.WriteLine();
                            labirynt.tab[klucz.x, klucz.y].e = 2;
                            labirynt.tab[klucz.x + 1, klucz.y].w = 2;
                        }
                        klucz = null;
                        labirynt.tab[gracz.x, gracz.y].klucz = null;
                    }
                }
                if (input == "podnies skarb")
                {
                    
                    if (labirynt.tab[gracz.x, gracz.y].skarb != null)
                    {
                        if(labirynt.tab[gracz.x, gracz.y].skarb.Mimikra() == null)
                        {
                            Console.WriteLine();
                            Console.WriteLine("Podniosłeś " + labirynt.tab[gracz.x, gracz.y].skarb.zloto + " sztuk złota");
                            Console.WriteLine("Podniosłeś diamenty w liczbie: " + labirynt.tab[gracz.x, gracz.y].skarb.diamenty);
                            Console.WriteLine();
                            gracz.zloto += labirynt.tab[gracz.x, gracz.y].skarb.zloto;
                            gracz.diamenty += labirynt.tab[gracz.x, gracz.y].skarb.diamenty;
                            labirynt.tab[gracz.x, gracz.y].skarb = null;
                        }
                        else
                        {
                            
                            Walka(gracz, labirynt.tab[gracz.x, gracz.y].skarb.Mimikra());
                            labirynt.tab[gracz.x, gracz.y].skarb = null;
						}
                    }

                }
                if (input == "podnies przedmiot")
                {
                    if (labirynt.tab[gracz.x, gracz.y].przedmiot != null)

                    {
                        Console.WriteLine();
                        Console.WriteLine("Podniosłeś: " + labirynt.tab[gracz.x, gracz.y].przedmiot.nazwa);
                        Console.WriteLine();
                        gracz.przedmiot = labirynt.tab[gracz.x, gracz.y].przedmiot;
                        gracz.Podnies(gracz.przedmiot);
                        labirynt.tab[gracz.x, gracz.y].przedmiot = null;
                    }
                }
                if (input == "walka")
                {
                    if (labirynt.tab[gracz.x, gracz.y].wrog != null)
                    {
                        Walka(gracz, labirynt.tab[gracz.x, gracz.y].wrog);
                        labirynt.tab[gracz.x, gracz.y].wrog = null;

                    }
                }
                if (input == "ekwipunek")
                {
                    gracz.Ekwipunek();
                }
                if (input == "help")
                {
                    Console.WriteLine();
                    Console.WriteLine("Użyj nazw kierunków świata aby się poruszać(n,s,w,e)");
                    Console.WriteLine("rozejrzyj - podaje co znajduje się w pomieszczeniu");
                    Console.WriteLine("podnies klucz/przedmiot/skarb - podnosi przedmiot jeśli znajduje się na polu");
                    Console.WriteLine("walka - rozpoczyna walkę jeśli na polu znajduje się wróg");
                    Console.WriteLine("ekwipunek - pokazuje aktualny ekwipunek");
                    Console.WriteLine();
                    Console.WriteLine("Gra się zakonczy gdy dojdziesz do pola końcowego");
                    Console.WriteLine("Powodzenia");
                }
                if (labirynt.tab[gracz.x, gracz.y].koniec == true)
                {
                    int punkty = gracz.diamenty * 1000 + gracz.zloto;
                    Console.WriteLine();
                    Console.WriteLine("Gratulacje, wygrałeś grę!");
                    Console.WriteLine("Uzyskałeś " + punkty + " punktów");
                    Console.WriteLine();
                    break;
                }
            }
        }
    }
}