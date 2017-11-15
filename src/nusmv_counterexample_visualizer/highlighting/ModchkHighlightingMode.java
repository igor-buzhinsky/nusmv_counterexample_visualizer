package nusmv_counterexample_visualizer.highlighting;

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
        return important ? ("<span style='text-decoration: underline; background-color: yellow;'>"
                + s + "</span>") : s;
    }

    @Override
    public String visualizeImportanceInTable(String s, boolean important) {
        return visualizeImportance(s, important);
    }
}
