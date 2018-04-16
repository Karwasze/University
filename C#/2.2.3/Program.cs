using System;
using System.Runtime.InteropServices;     // DLL support

class Execute
{
    [DllImport("Execute.dll")]
    public static extern int ExecuteC(int n, int f);
    [DllImport("Prime.dll")]
    public static extern int isPrimeC(int n);
    public int isPrimeCs(int val)
    {
        return ExecuteC(val, isPrimeC(val));
    }
    static void Main()
    {
        int a = Console.Read();
        Console.WriteLine(isPrimeC(a));
    }
    
}