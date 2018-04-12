using System;
namespace ProjektPO
{
    public class Pole
    {
        public int n, s, w, e;
        public Klucz klucz;
        public Wrog wrog;
        public Przedmiot przedmiot;
        public Skarb skarb;
        public bool koniec;
        public Pole()
        {
            n = 0;
            s = 0;
            w = 0;
            e = 0;
            klucz = null;
            skarb = null;
            wrog = null;
            przedmiot = null;
            koniec = false;
        }
    }
}
