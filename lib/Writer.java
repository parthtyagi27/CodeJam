
package lib;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer
{
    private final BufferedWriter writer;
    private final FileWriter fw;
    
    public Writer(String path) throws IOException
    {
        fw = new FileWriter(path, true);
        writer = new BufferedWriter(fw);
        //writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path, true)));
    }
    
    public void write(String n) throws IOException
    {
        writer.append(n);
        writer.newLine();
    }
    
    public void flush() throws IOException
    {
        writer.flush();
        writer.close();
    }
}
