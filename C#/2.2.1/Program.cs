using System;
using System.Runtime.InteropServices;
using System.Text;

public class Win32
{
    [DllImport("user32.dll", CharSet = CharSet.Auto)]
    public static extern IntPtr MessageBox(int hWnd, String text,
                    String caption, uint type);
    [DllImport("Advapi32.dll")]
    public static extern bool GetUserName(StringBuilder lpBuffer, ref int nSize);

}

public class HelloWorld
{
    public static void Main()
    {
        StringBuilder Buffer = new StringBuilder(64);
        int nSize = 64;
        Win32.GetUserName(Buffer, ref nSize);
        Win32.MessageBox(0,Buffer.ToString(), "Platform Invoke Sample", 0);
    }
}