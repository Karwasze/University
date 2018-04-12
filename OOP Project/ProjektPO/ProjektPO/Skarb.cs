using System;
namespace ProjektPO
{
    public class Skarb
    {
        public int zloto, diamenty, mimikra;
        public Skarb()
        {
            Random rnd = new Random();
            zloto = rnd.Next(1000, 5000);
            diamenty = rnd.Next(1, 20);
            mimikra = rnd.Next(0,10);
        }
        public Wrog Mimikra()
        {
            if (mimikra <= 5)
            {
                Wrog mim = new Wrog("Mimikra", 200);
                return mim;
            }
            return null;
        }
    }
}
