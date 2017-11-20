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
    public List<String> shortGraphicalAnnotateString(String str, boolean value, boolean important) {
        final Function<String, String> bold = value ? s -> "<b>" + s + "</b>" : s -> s;
        final int len = Util.lengthWithoutTags(str);
        return Arrays.asList((value ? "<font bgcolor=#ff9999>" : "<font color=#666666>") + bold.apply(str) + "</font>",
                bold.apply(important ? ("<font color=blue>" + Util.nChars('^', len) + "</font>")
                        : Util.nStrings("&nbsp", len)));
    }
}
