package nusmv_counterexample_visualizer.highlighting;

import java.util.*;

/**
 * Created by buzhinsky on 11/15/17.
 */
public abstract class HighlightingMode {
    public abstract String name();
    abstract String visualizeValueNoUrl(String s, boolean value, boolean highlight);
    public abstract String visualizeImportance(String s, boolean important);
    public abstract String visualizeImportanceInTable(String s, boolean important);

    public String visualizeValue(String s, boolean value, String url, boolean highlight) {
        return visualizeValueNoUrl(url != null ? ("<a href=" + url + " style='text-decoration:none'>" + s + "</a>") : s,
                value, highlight);
    }

    private static final Map<String, HighlightingMode> ALL_MODES = new LinkedHashMap<>();

    private static void init() {
        if (ALL_MODES.isEmpty()) {
            for (HighlightingMode hm : Arrays.asList(new DefaultHighlightingMode(), new ModchkHighlightingMode())) {
                ALL_MODES.put(hm.name(), hm);
            }
        }
    }

    public static Collection<HighlightingMode> modes() {
        init();
        return Collections.unmodifiableCollection(ALL_MODES.values());
    }

    public static HighlightingMode get(String name) {
        init();
        return ALL_MODES.get(name);
    }
}
