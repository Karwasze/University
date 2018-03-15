package com.strumienie;
import java.io.*;

public class Clearer {

    public String buffer ="";
    public String spaces = "";
    public FileReader reader;
    public FileWriter writer;
    int tabsize;

    public Clearer(int tabsize, File file)
    {
        this.tabsize = tabsize;
        try
        {
            this.reader = new FileReader(file);
            this.writer = new FileWriter("textedit");

            int data = reader.read();
            while(data != -1)
            {
                char dataChar = (char) data;
                data = reader.read();
                if(dataChar == '\n')
                {
                    bufferParse();
                    buffer = "";
                    spaces = "";
                }
                else
                {
                    buffer += dataChar;
                }
            }
            bufferParse();
            writer.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("The file doesn't exist.");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void bufferParse() throws IOException
    {
        int i = 0;
        int counter = 0;
        if(buffer.length() == 0)
        {
            return;
        }
        while (buffer.charAt(i) == ' ' || buffer.charAt(i) == '\t')
        {
            if(buffer.charAt(i) == ' ')
            {
                i++;
                counter++;
            }
            if(buffer.charAt(i) == '\t')
            {
                i++;
                counter += tabsize;
            }
        }
        buffer = buffer.trim().replaceAll("\\s+", " ");
        for (int j = 0; j < counter; j++)
        {
            spaces += " ";
        }
        buffer = spaces + buffer + '\n';
        writer.write(buffer);
    }
}