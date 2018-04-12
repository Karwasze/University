using System;
namespace ProjektPO
{
    public class Labirynt
    {
        public Pole[,] tab;
        public Labirynt(int w, int h)
        {
            tab = new Pole[w,h];
            for (int i = 0; i < w; i++)
                for (int j = 0; j < h; j++)
                    tab[i, j] = new Pole();
        }
    }
}
