using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace _2._3._4
{
    public class ListHelper
    {
        public static List<TOutput> ConvertAll<T, TOutput>(List<T> list, Converter<T, TOutput> converter)
        {
            List<TOutput> outputlist = list.ConvertAll(converter);
            return outputlist;
        }

        public static List<T> FindAll<T>(List<T> list, Predicate<T> match)
        {
            List<T> outputlist = list.FindAll(match);
            return outputlist;
        }
       
        public static void ForEach<T>(List<T> list, Action<T> action)
        {
            list.ForEach(action);
        }

        public static int RemoveAll<T>(List<T> list, Predicate<T> match)
        {
            int outputlist = list.RemoveAll(match);
            return outputlist;
        }

        public static void Sort<T>(List<T> list, Comparison<T> comparison)
        {
            list.Sort(comparison);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
        }
    }
}
