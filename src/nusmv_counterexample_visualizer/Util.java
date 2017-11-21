package nusmv_counterexample_visualizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by buzhinsky on 11/19/17.
 */
public class Util {
    public static int lengthWithoutTags(String s) {
        return s.replaceAll("</?\\w+[^>]*>","").replaceAll("&(nbsp|lt|gt);", " ").length();
    }

    public static String nStrings(String s, int n) {
        return String.join("", Collections.nCopies(n, s));
    }

    public static String nChars(char c, int n) {
        final char[] arr = new char[n];
        Arrays.fill(arr, c);
        return new String(arr);
    }

    public static String par(Object text) {
        return "(" + text + ")";
    }

    public static List<String> bind(List<?>... lists) {
        final List<String> result = new ArrayList<>();
        for (int i = 0; i < lists[0].size(); i++) {
            final StringBuilder sb = new StringBuilder();
            for (List<?> list : lists) {
                sb.append(list.get(i));
            }
            result.add(sb.toString());
        }
        return result;
    }
}
