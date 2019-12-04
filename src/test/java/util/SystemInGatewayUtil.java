package util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SystemInGatewayUtil {
    private static final InputStream originalIn = System.in;

    public static void setOriginalIn() {
        System.setIn(originalIn);
    }

    public static void provideInput(String data) {
        ByteArrayInputStream in = new ByteArrayInputStream(data.getBytes());
        System.setIn(in);
    }
}
