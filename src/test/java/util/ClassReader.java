package util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.Buffer;

public class ClassReader extends BufferedReader{
    FileReader fr;

    private ClassReader(FileReader fr)
    {
        super(fr);
        this.fr = fr;
    }

    public static ClassReader openClass(Class c)
    {
        try {

            String s = "src.main.java." + c.getName();
            s = s.replace(".", "\\") + ".java";

            FileReader fr = new FileReader(new File(s));

            return new ClassReader(fr);

        }
        catch (Exception e)
        {
            System.out.println(e);
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

    public int find(String string) throws Exception
    {
        int count = 0;
        String fileOut;
        while((fileOut = readLine())!=null)
        {
            if(fileOut.equals(string))
                count++;
        }

        reset();
        return count;
    }

    public String findRowContains(String string) throws Exception
    {
        String fileOut;
        while((fileOut = readLine())!=null)
        {
            if(fileOut.contains(string))
            {
                reset();
                return fileOut;
            }

        }

        reset();
        return "";
    }

    public String getMethod(Method method) throws Exception
    {
        String fileOut;
        String methodName = Modifier.toString(method.getModifiers()) + " "
                + method.getReturnType().getName() + " "
                + method.getName();

        while((fileOut = readLine())!=null)
        {
            if(fileOut.contains(methodName) && containsParams(fileOut, method));
        }

        reset();
        return "";
    }

    private static boolean containsParams(String filed, Method method)
    {
        Class[] params = method.getParameterTypes();
        for (Class param: params) {
            //if(filed (param.getTypeName().toString()))
            //{return false;
        }
        return true;
    }
}
