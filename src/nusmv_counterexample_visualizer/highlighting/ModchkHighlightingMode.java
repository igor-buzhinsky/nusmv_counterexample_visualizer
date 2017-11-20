package nusmv_counterexample_visualizer.highlighting;

import nusmv_counterexample_visualizer.Util;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Created by buzhinsky on 11/15/17.
 */
class ModchkHighlightingMode extends HighlightingMode {
    @Override
    public String name() {
        return "MODCHK";
    }

    @Override
    public String visualizeValueNoUrl(String s, boolean value, boolean highlight) {
        final String color = (value ? "color=red" : "color=gray") + (highlight ? " bgcolor=yellow" : "");
        return "<font " + color + ">" + s + "</font>";
    }

    @Override
    public String visualizeImportance(String s, boolean important) {
        return important ? ("<font bgcolor=#ccccff>" + s + "</font>") : s;
    }

    @Override
    public String visualizeImportanceInTable(String s, boolean important) {
        return important ? ("<font bgcolor=blue>&nbsp;</font>" + s + "<font bgcolor=blue>&nbsp;</font>") : s;
    }

    @Override
    public List<String> shortGraphicalAnnotateStringNoUrl(String str, boolean value, boolean important,
                                                     boolean explanationHighlight) {
        final Function<String, String> bold = value ? s -> "<b>" + s + "</b>" : s -> s;
        final int len = Util.lengthWithoutTags(str);

        final String color;
        final String bgcolor;
        if (value) {
            if (explanationHighlight) {
                color = "white";
                bgcolor = "#ff0000"; // red
            } else {
                color = "black";
                bgcolor = "#ff9999"; // red
            }
        } else {
            if (explanationHighlight) {
                color = "white";
                bgcolor = "#666666"; // grey
            } else {
                color = "#999999"; // grey
                bgcolor = "white";
            }
        }

        return Arrays.asList("<font color=" + color + " bgcolor=" + bgcolor + ">" + bold.apply(str) + "</font>",
                "<font color=blue>" + bold.apply(Util.nStrings(important ? "^" : "&nbsp", len)) + "</font>");

    }
}
