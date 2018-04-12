using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2._3._3
{
    class Program
    {
        static void Main(string[] args)
        {
            List<int> list = new List<int>();
            list.Add(1);
            list.Add(2);
            list.Add(3);
            list.Add(4);

            List<string> lists = list.ConvertAll(
            new Converter<int, string>(delegate (int number)
            {
                return number.ToString();
            }));

            list.FindAll(delegate (int number)
            {
                return number > 2;
            });

            list.ForEach(delegate (int number)
            {
                Console.WriteLine(number);
            });

            list.RemoveAll(delegate (int number)
            {
                return number > 2;
            });

            list.ForEach(delegate (int number)
            {
                Console.WriteLine(number);
            });

            list.Sort(delegate (int x, int y)
            {
                return y.CompareTo(x);
            });

            list.ForEach(delegate (int number)
            {
                Console.WriteLine(number);
            });



        }
    }
}
