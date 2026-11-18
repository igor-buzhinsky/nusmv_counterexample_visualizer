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
    void doubleValue() {
        assertEquals(0.5, new BigRational(1, 2).doubleValue());
        assertEquals(1.0 / 3, new BigRational(1, 3).doubleValue(), 1e-15);
    }
}
