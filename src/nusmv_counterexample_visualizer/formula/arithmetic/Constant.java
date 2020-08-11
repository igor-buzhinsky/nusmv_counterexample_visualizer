package nusmv_counterexample_visualizer.formula.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by buzhinsky on 11/20/17.
 */
public class Constant extends ArithmeticExpression {
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
            // parse a rational number
            final String strValue = name.toLowerCase();
            // decimal format?
            if (strValue.contains(".") || strValue.contains("e") ) {
                final BigDecimal x = new BigDecimal(strValue);
                BigInteger numerator = x.unscaledValue();
                BigInteger denominator = new BigInteger("1");
                if (x.scale() <= 0) {
                    numerator = numerator.multiply(new BigInteger("10").pow(-x.scale()));
                } else {
                    denominator = denominator.multiply(new BigInteger("10").pow(x.scale()));
                }
                return new BigRational(numerator, denominator);
            } else if (strValue.startsWith("f'") || strValue.startsWith("-f'")) {
                return new BigRational(strValue.replace("f'", ""));
            } else {
                throw new RuntimeException("Unknown type/format of constant " + name + ".");
            }
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
