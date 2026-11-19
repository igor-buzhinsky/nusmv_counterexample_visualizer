package nusmv_counterexample_visualizer.formula.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class Constant extends ArithmeticExpression {
    // NuSMV symbolic constants (enumeration values) are identifiers. Unlike the formula grammar, dashes are
    // accepted here so that traces with such values can still be loaded (NuSMV allows dashes in identifiers).
    private static final Pattern SYMBOLIC_CONSTANT = Pattern.compile("[A-Za-z_][A-Za-z0-9_$#\\-]*");

    /**
     * Whether a value printed in a trace is a symbolic constant (and not a Boolean or a number).
     */
    static boolean isSymbolic(String value) {
        return !value.equals("TRUE") && !value.equals("FALSE") && SYMBOLIC_CONSTANT.matcher(value).matches();
    }

    public Constant(String name) {
        super(name);
    }

    @Override
    public Object calculate(Map<String, List<String>> values, int position) {
        if (name.equals("TRUE")) {
            return true;
        } else if (name.equals("FALSE")) {
            return false;
        }

        try {
            return Integer.parseInt(name);
        } catch (NumberFormatException ignored) {
            // must be checked before the decimal format since identifiers may contain "e"
            if (isSymbolic(name)) {
                return new SymbolicValue(name);
            }
            final BigRational result;
            // parse a rational number
            final String strValue = name.toLowerCase();
            // decimal format?
            if (strValue.contains(".") || strValue.contains("e")) {
                final BigDecimal x = new BigDecimal(strValue);
                BigInteger numerator = x.unscaledValue();
                BigInteger denominator = BigInteger.ONE;
                if (x.scale() <= 0) {
                    numerator = numerator.multiply(BigInteger.TEN.pow(-x.scale()));
                } else {
                    denominator = denominator.multiply(BigInteger.TEN.pow(x.scale()));
                }
                result = new BigRational(numerator, denominator);
            } else if (strValue.startsWith("f'") || strValue.startsWith("-f'")) {
                result = new BigRational(strValue.replace("f'", ""));
            } else {
                throw new RuntimeException("Unknown type/format of constant " + name + ".");
            }
            return result;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Set<String> variableSet() {
        return Collections.emptySet();
    }
}
