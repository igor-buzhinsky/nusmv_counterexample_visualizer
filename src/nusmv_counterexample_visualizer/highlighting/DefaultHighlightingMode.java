package nusmv_counterexample_visualizer.highlighting;

import nusmv_counterexample_visualizer.Util;

import java.util.Arrays;
import java.util.List;

/**
 * Created by buzhinsky on 11/15/17.
 */
class DefaultHighlightingMode extends HighlightingMode {
    @Override
    public String name() {
        return "Default";
    }

    @Override
    public String visualizeValueNoUrl(String s, boolean value, boolean highlight) {
        final String color = value && highlight ? "color=green bgcolor=yellow"
                : value ? "color=green bgcolor=#eeffee"
                : highlight ? "color=red bgcolor=yellow" : "color=red bgcolor=#ffeeee";
        return "<font " + color + ">" + s + "</font>";
    }

    @Override
    public String visualizeImportance(String s, boolean important) {
        return important ? ("<font bgcolor=yellow>" + s + "</font>") : s;
    }

    @Override
    public String visualizeImportanceInTable(String s, boolean important) {
        return visualizeImportance(s, important);
    }

    @Override
    public List<String> shortGraphicalAnnotateString(String str, boolean value, boolean important) {
        return Arrays.asList("<font bgcolor=" + (value ? "#ccffcc" : "#ffcccc") + ">" + str + "</font>",
                (important ? "<font color=black bgcolor=yellow>" : "") + Util.nStrings(important ? "*" : "&nbsp",
                        Util.lengthWithoutTags(str)) + (important ? "</font>" : ""));
    }
}
