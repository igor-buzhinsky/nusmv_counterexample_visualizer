package nusmv_counterexample_visualizer.formula.arithmetic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigRationalTest {
    @Test
    void fractionsAreReducedWithPositiveDenominator() {
        assertEquals("1/2", new BigRational(2, 4).toString());
        assertEquals("-1/2", new BigRational(1, -2).toString());
        assertEquals("1/2", new BigRational(-1, -2).toString());
        assertEquals("0", new BigRational(0, 5).toString());
        assertEquals("3", new BigRational(6, 2).toString());
    }

    @Test
    void parsesIntegersAndFractions() {
        assertEquals(new BigRational(-343, 1273), new BigRational("-343/1273"));
        assertEquals(new BigRational(42), new BigRational("42"));
        assertThrows(IllegalArgumentException.class, () -> new BigRational("1/2/3"));
    }

    @Test
    void zeroDenominatorIsRejected() {
        assertThrows(ArithmeticException.class, () -> new BigRational(1, 0));
        assertThrows(ArithmeticException.class, () -> BigRational.ZERO.reciprocal());
    }

    @Test
    void arithmetic() {
        assertEquals(new BigRational(5, 6), new BigRational(1, 2).plus(new BigRational(1, 3)));
        assertEquals(new BigRational(-1, 3), new BigRational(1, 6).minus(new BigRational(-4, -8)));
        assertEquals(BigRational.ONE, new BigRational(4, 17).times(new BigRational(17, 4)));
        assertEquals(new BigRational(3, 2), new BigRational(3, 4).divides(new BigRational(1, 2)));
        assertEquals(new BigRational(1073741789, 12),
                new BigRational(1073741789, 20).plus(new BigRational(1073741789, 30)));
        assertEquals(new BigRational(2, 3), new BigRational(-2, 3).abs());
        assertEquals(BigRational.ONE, new BigRational(8, 9).plus(new BigRational(1, 9)));
        assertEquals(new BigRational(1, 120000000),
                new BigRational(1, 200000000).plus(new BigRational(1, 300000000)));
        assertEquals(new BigRational(-1, 600000000),
                new BigRational(-1, 200000000).plus(new BigRational(1, 300000000)));
        assertEquals(new BigRational(841, 961),
                new BigRational(3037141, 3247033).times(new BigRational(3037547, 3246599)));
    }

    @Test
    void comparisonAndEqualityAreConsistent() {
        final BigRational half = new BigRational(1, 2);
        final BigRational twoQuarters = new BigRational(2, 4);
        assertEquals(half, twoQuarters);
        assertEquals(half.hashCode(), twoQuarters.hashCode());
        assertEquals(0, half.compareTo(twoQuarters));
        assertTrue(new BigRational(1, 3).compareTo(half) < 0);
        assertTrue(new BigRational(-1, 3).isNegative());
        assertTrue(BigRational.ZERO.isZero());
        assertNotEquals(half, "1/2");
    }

    @Test
    void zeroHasOneRepresentation() {
        assertEquals("0", new BigRational(0, -7).toString());
        assertEquals("0", new BigRational(3, 4).minus(new BigRational(6, 8)).toString());
        assertEquals(BigRational.ZERO.hashCode(), new BigRational(0, 5).hashCode());
        assertFalse(BigRational.ZERO.isNegative());
    }

    @Test
    void negativeNumbersAreOrdered() {
        assertTrue(new BigRational(-1, 2).compareTo(new BigRational(-1, 3)) < 0);
        assertTrue(new BigRational(-1, 2).compareTo(BigRational.ZERO) < 0);
        assertEquals(new BigRational(1, 2), new BigRational(-1, 2).negate());
        assertEquals("-2", new BigRational(1, 2).divides(new BigRational(-1, 4)).toString());
    }

    @Test
    void parsesSignsAndTrailingSlashes() {
        assertEquals("-1/2", new BigRational("1/-2").toString());
        assertEquals("5", new BigRational("+5").toString());
        assertEquals("0", new BigRational("-0").toString());
        // String.split drops trailing empty parts
        assertEquals("1", new BigRational("1/").toString());
        assertEquals("1/2", new BigRational("1/2/").toString());
    }

    @Test
    void longExtremesAreExact() {
        assertEquals("-9223372036854775808", new BigRational(Long.MIN_VALUE).toString());
        assertEquals("9223372036854775808", new BigRational(Long.MIN_VALUE).negate().toString());
        assertEquals("1/9223372036854775808", new BigRational(-1, Long.MIN_VALUE).toString());
    }

    @Test
    void invalidInputIsRejected() {
        assertThrows(NumberFormatException.class, () -> new BigRational("a/2"));
        assertThrows(NumberFormatException.class, () -> new BigRational("/2"));
        assertThrows(NumberFormatException.class, () -> new BigRational(" 1"));
        assertEquals("For input string: \"1//2\"",
                assertThrows(IllegalArgumentException.class, () -> new BigRational("1//2")).getMessage());
        assertThrows(ArithmeticException.class, () -> new BigRational("1/0"));
        assertThrows(ArithmeticException.class, () -> BigRational.ONE.divides(BigRational.ZERO));
    }

    @Test
    void largeValuesAreExact() {
        final BigRational big = new BigRational("123456789012345678901234567890/11");
        assertEquals("123456789012345678901234567890/11", big.toString());
        assertEquals("1", big.divides(big).toString());
        assertEquals("-123456789012345678901234567890", big.times(new BigRational(-11)).toString());
    }

    @Test
    void doubleValue() {
        assertEquals(0.5, new BigRational(1, 2).doubleValue());
        assertEquals(1.0 / 3, new BigRational(1, 3).doubleValue(), 1e-15);
    }
}
