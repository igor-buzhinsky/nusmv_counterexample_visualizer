package nusmv_counterexample_visualizer.highlighting;

import nusmv_counterexample_visualizer.Util;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by buzhinsky on 11/15/17.
 */
public class DefaultHighlightingMode extends HighlightingMode {
    private static final String WHITE = "#ffffff";
    private static final String BLACK = "#000000";

    public static String HIGHLIGHT_COLOR;
    public static String TRUE_COLOR;
    public static String FALSE_COLOR;

    public static String HIGHLIGHT_CHAR;

    @Override
    public String name() {
        return "Default";
    }

    private static String adjust(String color, int value) {
        Color c;
        try {
            c = Color.decode(color);
        } catch (NumberFormatException e) {
            c = Color.BLACK;
        }
        final int[] components = new int[] { c.getRed(), c.getGreen(), c.getBlue() };
        for (int i = 0; i < components.length; i++) {
            components[i] += Math.round((255 - components[i]) * (value / 255.));
            components[i] = Math.min(components[i], 255);
            components[i] = Math.max(components[i], 0);
        }
        return String.format("#%02x%02x%02x", components[0], components[1], components[2]);
    }

    private static String colors(String fg, String bg, String str) {
        return "<font color=" + fg + " bgcolor=" + bg + ">" + str + "</font>";
    }

    @Override
    public String visualizeValueNoUrl(String s, boolean value, boolean highlight) {
        return colors(value ? TRUE_COLOR : FALSE_COLOR,
                highlight ? HIGHLIGHT_COLOR : adjust(value ? TRUE_COLOR : FALSE_COLOR, 0xee), s);
    }

    @Override
    public String visualizeImportance(String s, boolean important) {
        return important ? colors(BLACK, HIGHLIGHT_COLOR, s) : s;
    }

    @Override
    public String visualizeImportanceInTable(String s, boolean important) {
        return visualizeImportance(s, important);
    }

    @Override
    public List<String> shortGraphicalAnnotateStringNoUrl(String str, boolean value, boolean important,
                                                     boolean explanationHighlight) {
        return Arrays.asList(
                colors(explanationHighlight ? WHITE : BLACK,
                        adjust(value ? TRUE_COLOR : FALSE_COLOR, explanationHighlight ? 0 : 0xbb), str),
                colors(BLACK,
                        important ? HIGHLIGHT_COLOR : WHITE,
                        Util.nStrings(important ? HIGHLIGHT_CHAR : "&nbsp", Util.lengthWithoutTags(str)))
        );
    }
}
