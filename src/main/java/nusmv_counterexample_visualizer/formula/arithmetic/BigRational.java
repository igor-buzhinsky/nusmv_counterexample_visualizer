package nusmv_counterexample_visualizer.formula.arithmetic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * An exact rational number with arbitrary-precision numerator and denominator, used for nuXmv reals.
 *
 * <p>Instances are immutable and always normalized: the fraction is reduced and the denominator is positive, so
 * each number has exactly one representation and {@link #equals} can compare the fields directly.
 */
public final class BigRational implements Comparable<BigRational> {
    public static final BigRational ZERO = new BigRational(0);
    public static final BigRational ONE = new BigRational(1);

    private final BigInteger numerator;
    private final BigInteger denominator;

    /**
     * @throws ArithmeticException if the denominator is zero
     */
    public BigRational(BigInteger numerator, BigInteger denominator) {
        if (denominator.signum() == 0) {
            throw new ArithmeticException("Denominator is zero");
        }
        if (denominator.signum() < 0) {
            numerator = numerator.negate();
            denominator = denominator.negate();
        }
        final BigInteger gcd = numerator.gcd(denominator);
        // gcd(0, d) = d, so zero becomes 0/1
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    public BigRational(long numerator, long denominator) {
        this(BigInteger.valueOf(numerator), BigInteger.valueOf(denominator));
    }

    public BigRational(long value) {
        this(value, 1);
    }

    /**
     * Parses an integer ("-5") or a fraction ("-3/4"), as split by {@link String#split(String)} on "/". As a
     * consequence, trailing slashes are ignored: "1/" is parsed as 1 and "1/2/" as 1/2.
     *
     * @throws NumberFormatException if a part is not an integer, e.g. empty as in "/2" or with whitespace
     * @throws IllegalArgumentException if there are more than two parts, e.g. "1/2/3" or "1//2"
     * @throws ArithmeticException if the denominator is zero
     */
    public BigRational(String s) {
        this(parse(s));
    }

    private BigRational(BigInteger[] numeratorAndDenominator) {
        this(numeratorAndDenominator[0], numeratorAndDenominator[1]);
    }

    private static BigInteger[] parse(String s) {
        final String[] tokens = s.split("/");
        switch (tokens.length) {
            case 1: return new BigInteger[] {new BigInteger(tokens[0]), BigInteger.ONE};
            case 2: return new BigInteger[] {new BigInteger(tokens[0]), new BigInteger(tokens[1])};
            default: throw new IllegalArgumentException("For input string: \"" + s + "\"");
        }
    }

    public BigRational plus(BigRational other) {
        return new BigRational(numerator.multiply(other.denominator).add(other.numerator.multiply(denominator)),
                denominator.multiply(other.denominator));
    }

    public BigRational minus(BigRational other) {
        return plus(other.negate());
    }

    public BigRational times(BigRational other) {
        return new BigRational(numerator.multiply(other.numerator), denominator.multiply(other.denominator));
    }

    /**
     * @throws ArithmeticException if {@code other} is zero
     */
    public BigRational divides(BigRational other) {
        return times(other.reciprocal());
    }

    public BigRational negate() {
        return new BigRational(numerator.negate(), denominator);
    }

    public BigRational abs() {
        return isNegative() ? negate() : this;
    }

    /**
     * @throws ArithmeticException if this number is zero
     */
    public BigRational reciprocal() {
        return new BigRational(denominator, numerator);
    }

    public boolean isZero() {
        return numerator.signum() == 0;
    }

    public boolean isNegative() {
        return numerator.signum() < 0;
    }

    /**
     * An approximation as a double: the quotient is rounded to 34 significant decimal digits and then to a double,
     * so the result may differ from the nearest double in the last bit.
     */
    public double doubleValue() {
        return new BigDecimal(numerator).divide(new BigDecimal(denominator), MathContext.DECIMAL128).doubleValue();
    }

    @Override
    public int compareTo(BigRational other) {
        // Both denominators are positive, so cross-multiplication preserves the order
        return numerator.multiply(other.denominator).compareTo(other.numerator.multiply(denominator));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof BigRational)) {
            return false;
        }
        final BigRational other = (BigRational) o;
        return numerator.equals(other.numerator) && denominator.equals(other.denominator);
    }

    @Override
    public int hashCode() {
        return 31 * numerator.hashCode() + denominator.hashCode();
    }

    /**
     * "n" for integers, "n/d" otherwise.
     */
    @Override
    public String toString() {
        return denominator.equals(BigInteger.ONE) ? numerator.toString() : numerator + "/" + denominator;
    }
}
