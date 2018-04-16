using System;
using System.Runtime.InteropServices;     // DLL support

class Prime
{
    [DllImport("Prime.dll")]
    public static extern int isPrimeC(int num);

    static void Main()
    {
            int a = Console.Read();
            Console.WriteLine(isPrimeC(a));
        
    }
}