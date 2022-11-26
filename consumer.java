import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.*;

public class consumer extends Thread
{
    buffer buf;
    int sizee;
    String fileName;
    GUI gui;

    public consumer(buffer buf, int size, String fName, GUI g)
    {
        this.buf = buf;
        sizee=size;
        fileName=fName;
        gui=g;
    }
    public int getLargest()
    {
        return buf.largest;
    }
    public int getCount()
    {
        return buf.count;
    }

    public void run()
    {
        FileWriter file=null;
        try
        {
            file = new FileWriter(fileName);
            BufferedWriter Filewrite=new BufferedWriter(file);
            System.out.println("Buffered Writer start writing...");
            long start = System.currentTimeMillis();
            for(int i=1;i<=sizee;i++)
            {
                Object x=buf.consume();
                Filewrite.append("{"+x+"}   ");

                gui.setLargestPnum(String.valueOf(getLargest()));
                gui.setNumElemGenerated(getCount());
                long finish=System.currentTimeMillis();
                long timeElapsed=finish -start;
                gui.setTimeElapsed(timeElapsed);
            }
            Filewrite.close();
        }
        catch (IOException except)
        {
            except.printStackTrace();
        }
    }
}
