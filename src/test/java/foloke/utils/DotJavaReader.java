package foloke.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class DotJavaReader extends BufferedReader{
    private FileReader fr;

    private DotJavaReader(FileReader fr)
    {
        super(fr);
        this.fr = fr;
    }

    public static DotJavaReader openClass(Class c)
    {
        try {

            String s = "src.main.java." + c.getName();
            s = s.replace(".", "\\") + ".java";

            FileReader fr = new FileReader(new File(s));

            return new DotJavaReader(fr);

        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

        return null;
    }

    public void close()
    {
        try {
            fr.close();
            super.close();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
