package nusmv_counterexample_visualizer.highlighting;

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
        return important ? ("<font bgcolor=yellow><i>" + s + "</i></font>") : s;
    }

    @Override
    public String visualizeImportanceInTable(String s, boolean important) {
        return visualizeImportance(s, important);
    }
}
