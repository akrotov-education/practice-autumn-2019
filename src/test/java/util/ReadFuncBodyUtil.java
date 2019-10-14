package util;

import java.util.List;

public class ReadFuncBodyUtil {
    public static List<String> getFuncBody(List<String> source, int startLine) {
        int openBraces = 1;
        int i;
        for (i = startLine + 1; openBraces > 0; i++) {
            String line = source.get(i);
            int countOpen = line.length() - line.replace("{", "").length();
            int countClose = line.length() - line.replace("}", "").length();

            openBraces += countOpen;
            openBraces -= countClose;
        }

        List<String> body = source.subList(startLine + 1, i - 1);

        return body;
    }
}
