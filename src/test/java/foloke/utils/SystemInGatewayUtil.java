package foloke.utils;

//SystemOutGatewayUtil adaptation for input

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class SystemInGatewayUtil {

    private static final InputStream originalIn = System.in;
    private static ByteArrayInputStream inContent = new ByteArrayInputStream("".getBytes());
    private static InputStream customIn = new CustomInputStream();

    public static void setOriginalIn() {
        System.setIn(originalIn);
    }

    public static void setCustomIn(String userInput) {
        inContent = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inContent);
    }

    public static ByteArrayInputStream getInputArray()
    {
        return inContent;
    }

    private static class CustomInputStream extends InputStream {

        @Override
        public int read(){
            return inContent.read();
        }

        @Override
        public void close() throws IOException {
            super.close();
            inContent.close();
        }
    }

}
