package util;

import java.io.*;

public class SystemOutGatewayUtil {

    private static final PrintStream originalOut = System.out;
    private static ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static PrintStream customOut = new PrintStream(new CustomOutputStream());

    public static void setOriginalOut() {
        System.setOut(originalOut);
    }

    public static void setCustomOut() {
        System.setOut(customOut);
    }

    public static ByteArrayOutputStream getOutputArray() {
        return outContent;
    }

    public static void clearOutput() {
        outContent = new ByteArrayOutputStream();
    }

    private static class CustomOutputStream extends OutputStream {

        @Override
        public void write(int b) throws IOException {
            outContent.write(b);
            originalOut.write(b);
        }

        @Override
        public void flush() throws IOException {
            super.flush();
            outContent.flush();
            originalOut.flush();
        }

        @Override
        public void close() throws IOException {
            super.close();
            outContent.close();
        }
    }

}
