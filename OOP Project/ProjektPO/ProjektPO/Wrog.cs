using System;
namespace ProjektPO
{
    public class Wrog
    {
        public int x, y, obrona, atak;
        public string nazwa;
        public Wrog(string nazwa, int obrona)
        {
            this.nazwa = nazwa;
            this.obrona = obrona;
            atak = 10;
        }
        public void Atak(Gracz gracz)
        {
            gracz.tobrona -= atak;
            Console.WriteLine();
            Console.WriteLine("Wróg zadał Ci " + atak + " punktów obrażeń");
			Console.WriteLine("Twoje HP wynosi " + gracz.tobrona);
            Console.WriteLine();
        }

    }
}
