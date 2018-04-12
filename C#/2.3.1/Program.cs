using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Collections;
using System.Diagnostics;


namespace _2._3._1
{
    class Program
    {
        static void Main(string[] args)
        {
            ArrayList arrlist = new ArrayList();
            List<int>  list= new List<int>();
            Hashtable hashtable = new Hashtable();
            Dictionary<int, int> dict = new Dictionary<int, int>();
            
            //ARRAYLIST
            Console.WriteLine("ARRAYLIST");
            Stopwatch sw = new Stopwatch();
            sw.Start();
            for (int i = 0; i < 1000000; i++)
            {
                arrlist.Add(i);
            }
            sw.Stop();
            Console.WriteLine("Dodawanie 1000000 elementów do arraylist trwało={0}", sw.Elapsed);
            sw.Reset();

            sw.Start();
            for (int i = 0; i < 1000000; i++)
            {
                int test = (int)arrlist[i];
            }
            sw.Stop();
            Console.WriteLine("Podejrzenie 1000000 elementów arraylist trwało={0}", sw.Elapsed);
            sw.Reset();

            sw.Start();
            arrlist.RemoveRange(0, 999999);
            sw.Stop();
            Console.WriteLine("Usunięcie 1000000 elementów z arraylist trwało={0}", sw.Elapsed);
            sw.Reset();
            
            //LIST
            Console.WriteLine("LIST");
            sw.Start();
            for (int i = 0; i < 1000000; i++)
            {
                list.Add(i);
            }
            sw.Stop();
            Console.WriteLine("Dodawanie 1000000 elementów do list trwało={0}", sw.Elapsed);
            sw.Reset();

            sw.Start();
            for (int i = 0; i < 1000000; i++)
            {
                int test = list[i];
            }
            sw.Stop();
            Console.WriteLine("Podejrzenie 1000000 elementów do list trwało={0}", sw.Elapsed);
            sw.Reset();

            sw.Start();
            list.RemoveRange(0, 999999);
            sw.Stop();
            Console.WriteLine("Usunięcie 1000000 elementów z list trwało={0}", sw.Elapsed);
            sw.Reset();

            //HASHTABLE
            Console.WriteLine("HASHTABLE");
            sw.Start();
            for (int i = 0; i < 1000000; i++)
            {
                hashtable.Add(i, i);
            }
            sw.Stop();
            Console.WriteLine("Dodawanie 1000000 elementów do hashtable trwało={0}", sw.Elapsed);
            sw.Reset();

            sw.Start();
            for (int i = 0; i < 1000000; i++)
            {
                int key = (int)hashtable[i];
            }
            sw.Stop();
            Console.WriteLine("Podejrzenie 1000000 elementów do hashtable trwało={0}", sw.Elapsed);
            sw.Reset();

            sw.Start();
            for (int i = 0; i < 1000000; i++)
            {
                hashtable.Remove(i);
            }
            sw.Stop();
            Console.WriteLine("Usunięcie 1000000 elementów z list trwało={0}", sw.Elapsed);
            sw.Reset();

            //DICTIONARY
            Console.WriteLine("DICTIONARY");
            sw.Start();
            for (int i = 0; i < 1000000; i++)
            {
                dict.Add(i, i);
            }
            sw.Stop();
            Console.WriteLine("Dodawanie 1000000 elementów do dictionary trwało={0}", sw.Elapsed);
            sw.Reset();

            sw.Start();
            for (int i = 0; i < 1000000; i++)
            {
                int key = dict[i];
            }
            sw.Stop();
            Console.WriteLine("Podejrzenie 1000000 elementów do dictionary trwało={0}", sw.Elapsed);
            sw.Reset();

            sw.Start();
            for (int i = 0; i < 1000000; i++)
            {
                dict.Remove(i);
            }
            sw.Stop();
            Console.WriteLine("Usunięcie 1000000 elementów z dictionary trwało={0}", sw.Elapsed);
            sw.Reset();
        }
    }
}
