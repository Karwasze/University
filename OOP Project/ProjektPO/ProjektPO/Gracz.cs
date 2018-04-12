using System;
namespace ProjektPO
{
    public class Gracz
    {
        public int x, y, wynik, atak, obrona, tatak, tobrona, zloto, diamenty;
        public Przedmiot przedmiot;
        public Gracz(int x, int y)
        {
            this.x = x;
            this.y = y;
            przedmiot = new Przedmiot(true);
            wynik = 0;
            atak += przedmiot.atak;
            obrona += przedmiot.obrona;
            zloto = 0;
            diamenty = 0;
        }
        public void Ekwipunek()
        {
            Console.WriteLine();
            Console.WriteLine("Posiadasz: ");
            Console.WriteLine(przedmiot.nazwa);
            Console.WriteLine("Atak: " + atak);
            Console.WriteLine("Obrona " + obrona);
            Console.WriteLine();
			Console.WriteLine("Złoto: " + zloto);
            Console.WriteLine("Diamenty: "+ diamenty);
        }

        public void Atak(string input, Wrog wrog)
        {
			if (input == "atak")
   			{
				wrog.obrona -= tatak;
                Console.WriteLine();
				Console.WriteLine("Zadałeś wrogowi " + tatak + " obrażeń!");
                Console.WriteLine("HP wroga wynosi " + wrog.obrona);
				Console.WriteLine();				
            }

			if (input == "magia")
			{
				przedmiot.Magia(this, wrog);
			}
        }
        public void Podnies(Przedmiot przedmiot)
        {
            atak -= this.przedmiot.atak;
            obrona -= this.przedmiot.obrona;
            atak = przedmiot.atak;
            obrona = przedmiot.obrona;
        }
    }
}
