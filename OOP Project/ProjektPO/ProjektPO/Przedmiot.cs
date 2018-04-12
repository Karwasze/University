using System;
namespace ProjektPO
{
    public class Przedmiot
    {
        public string nazwa, magia, opis_magii;
        public int atak, obrona, temp;
        static string[] czlon1 = new string[]
        {"Świński ","Haniebny ","Srogi ","Bestialski ",
            "Uroczy ","Magiczny ","Gargantuiczny ","Krwisty ",
            "Wodny ","Ognisty ","Pusty "
        };
        static string[] czlon2 = new string[]
        {"berdysz ","topór ","miecz ","pancerz ","tasak ",
            "rapier ","nóż ","sztylet ","łuk ","naszyjnik ",
            "kalosz ","anihilator "
        };
		static string[] czlon3 = new string[]
		{"leczenia", "podwójnego uderzenia", "niszczenia",
            "anihilacji", "osłabienia", "chaosu", "wzmocnienia"
		};
        public Przedmiot()
        {
            Random rnd = new Random();
            magia = czlon3[rnd.Next(7)];
            nazwa = czlon1[rnd.Next(11)] + czlon2[rnd.Next(12)] + magia;
            atak = rnd.Next(5,20);
            obrona = rnd.Next(120, 200);
        }
        public Przedmiot(bool x)
        {
            nazwa = "Agresywne pięści podróżnika";
            atak = 1;
            obrona = 100;
            magia = "wzmocnienia";
        }
        public void Magia(Gracz gracz, Wrog wrog)
        {
            Random rnd = new Random();
            if(magia == "leczenia")
            {
                Console.WriteLine();
                Console.WriteLine("Uleczyłeś się o 20 puntków zdrowia");
                gracz.tobrona += 20;
                Console.WriteLine("Wróg uderza za " + wrog.atak + "punktów zdrowia");
                Console.WriteLine("Twoje HP wynosi: " + gracz.tobrona);
                Console.WriteLine("HP Wroga wynosi " + wrog.obrona);
                Console.WriteLine();
            }
            if(magia == "podwójnego uderzenia")
            {
                wrog.obrona -= 2 * gracz.tatak;
                Console.WriteLine();
                Console.WriteLine("Uderzasz podwójnie");
				Console.WriteLine("Twoje HP wynosi: " + gracz.tobrona);
				Console.WriteLine("HP Wroga wynosi " + wrog.obrona);
                Console.WriteLine();
            }
            if(magia == "niszczenia")
            {
                gracz.obrona = 0;
                Console.WriteLine();
                Console.WriteLine("Umierasz...");
                Console.WriteLine();
            }
            if(magia == "anihilacji")
            {
                Console.WriteLine();
                Console.WriteLine("Zabijasz wroga");
                Console.WriteLine();
                wrog.obrona = 0;
            }
            if(magia == "osłabienia")
            {
                if ((wrog.atak - 5) < 0)
                {
                    Console.WriteLine();
                    Console.WriteLine("Nie możesz bardziej osłabić wroga");
                    Console.WriteLine();
                }
                else
                {
                    wrog.atak -= 5;
                    Console.WriteLine();
                    Console.WriteLine("Atak wroga wynosi teraz " + wrog.atak);
                    Console.WriteLine();
                }
            }
            if(magia == "chaosu")
            {
                temp = rnd.Next(5);
                if(temp == 1)
                {
                    Console.WriteLine();
                    Console.WriteLine("Zaklęcie było potężne i zabiło wroga");
                    Console.WriteLine();
                    wrog.obrona = 0;
                }
                else
                {
                    
                    Console.WriteLine();
                    Console.WriteLine("Zaklęcie nie zadziałało, może spróbuj jeszcze raz...");
                    Console.WriteLine();
				}
            }
            if(magia == "wzmocnienia")
            {
                gracz.tatak += 10;
                Console.WriteLine();
                Console.WriteLine("Twój atak wynosi teraz " + gracz.tatak);
                Console.WriteLine();
            }
        }
    }
}
