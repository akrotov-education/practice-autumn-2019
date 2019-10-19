package util;

import java.io.*;

public class SystemInGatewayUtil {

    private static final InputStream originalIn = System.in;
    private static ByteArrayInputStream inContent = new ByteArrayInputStream(new byte[256]);
    private static InputStream customIn = new CustomInputStream();

    public static void setOriginalIn() {
        System.setIn(originalIn);
    }

    public static void setCustomIn() {
        System.setIn(customIn);
    }

    public static ByteArrayInputStream getInputArray() {
        return inContent;
    }

    public static void clearInput() {
        inContent = new ByteArrayInputStream(new byte[256]);
    }

    private static class CustomInputStream extends InputStream {

        @Override
        public int read() throws IOException {
            return inContent.read();
        }

        @Override
        public void close() throws IOException {
            super.close();
            inContent.close();
        }
    }

}
