package nusmv_counterexample_visualizer;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import java.awt.*;
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

    static void unifyTable(JTable table) {
        table.setDefaultEditor(Object.class, null);
        table.setFont(table.getFont().deriveFont((float) GUI.SMALL_FONT_SIZE));
        table.getTableHeader().setFont(table.getFont());
        table.setRowHeight(table.getFont().getSize() + 4);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.LEFT);
        resizeColumnWidth(table);
    }

    private static void resizeColumnWidth(JTable table) {
        final TableColumnModel columnModel = table.getColumnModel();

        for (int column = 0; column < table.getColumnCount(); column++) {
            int width = 1;

            final TableColumn tableColumn = columnModel.getColumn(column);
            TableCellRenderer renderer = tableColumn.getHeaderRenderer();
            if (renderer == null) {
                renderer = table.getTableHeader().getDefaultRenderer();
            }
            width = Math.max(Math.min(renderer.getTableCellRendererComponent(table, tableColumn.getHeaderValue(),
                    false, false, -1, column).getPreferredSize().width, 200), width);

            for (int row = 0; row < table.getRowCount(); row++) {
                final Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                width = Math.max(comp.getPreferredSize().width + 1, width);
            }
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }
}
