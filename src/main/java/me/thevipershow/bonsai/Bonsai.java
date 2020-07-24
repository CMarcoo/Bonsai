/*
 * MIT License
 *
 * Copyright (c) 2020 TheViperShow
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package me.thevipershow.bonsai;

import java.nio.BufferOverflowException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

import static java.lang.Math.*;

public final class Bonsai {
    private Bonsai() {
        throw new UnsupportedOperationException(getClass().getSimpleName() + " is a utility class, hence cannot be instantiated.");
    }

    public static double nroot(final double number, final double pow) {
        return round(pow(number, 1.d / pow));
    }

    public static <T extends Number> double arithmeticMean(final T[] numbers) {
        final int count = numbers.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        if (count == 1) return numbers[0].doubleValue();
        double sum = 0.d;
        for (final T t : numbers)
            sum += t.doubleValue();
        return sum / count;
    }

    public static <T extends Number> double arithmeticMean(final Collection<T> numbers) {
        final int count = numbers.size();
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty collection.");
        double sum = 0.d;
        for (final T t : numbers)
            sum += t.doubleValue();
        return sum / count;
    }

    public static double arithmeticMean(final int[] ints) {
        final int count = ints.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        if (count == 1) return ints[0];
        double sum = 0.d;
        for (final int i : ints)
            sum += i;
        return sum / count;
    }

    public static double arithmeticMean(final short[] shorts) {
        final int count = shorts.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        if (count == 1) return shorts[0];
        double sum = 0.d;
        for (final short b : shorts)
            sum += b;
        return sum / count;
    }

    public static double arithmeticMean(final byte[] bytes) {
        final int count = bytes.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        if (count == 1) return bytes[0];
        double sum = 0.d;
        for (final byte b : bytes)
            sum += b;
        return sum / count;
    }

    public static double arithmeticMean(final double[] doubles) {
        final int count = doubles.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        if (count == 1) return doubles[0];
        double sum = 0.d;
        for (final double d : doubles)
            sum += d;
        return sum / count;
    }

    public static double arithmeticMean(final float[] floats) {
        final int count = floats.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        if (count == 1) return floats[0];
        double sum = 0.d;
        for (final float f : floats)
            sum += f;
        return sum / count;
    }

    public static <T extends Number> double geometricMean(final T[] numbers) {
        final int count = numbers.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        double product = 1.d;
        for (final T t : numbers)
            product *= t.doubleValue();
        return nroot(product, count);
    }

    public static <T extends Number> double geometricMean(final Collection<T> numbers) {
        final int count = numbers.size();
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty collection.");
        double product = 1.d;
        for (final T t : numbers)
            product *= t.doubleValue();
        return nroot(product, count);
    }

    public static double geometricMean(final int[] ints) {
        final int count = ints.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        double product = 1.d;
        for (final int i : ints)
            product *= i;
        return nroot(product, count);
    }

    public static double geometricMean(final short[] shorts) {
        final int count = shorts.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        double product = 1.d;
        for (final short s : shorts)
            product *= s;
        return nroot(product, count);
    }

    public static double geometricMean(final byte[] bytes) {
        final int count = bytes.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        double product = 1.d;
        for (final byte b : bytes)
            product *= b;
        return nroot(product, count);
    }

    public static double geometricMean(final double[] doubles) {
        final int count = doubles.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        double product = 1.d;
        for (final double d : doubles)
            product *= d;
        return nroot(product, count);
    }

    public static double geometricMean(final float[] floats) {
        final int count = floats.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform arithmetic mean on an empty array.");
        double product = 1.d;
        for (final float f : floats)
            product *= f;
        return nroot(product, count);
    }

    public static <T extends Number> double harmonicMean(final T[] numbers) {
        final int count = numbers.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform harmonic mean on an empty array.");
        double reciprocalSum = 0.d;
        for (final T t : numbers)
            reciprocalSum += 1.d / t.doubleValue();
        return count / reciprocalSum;
    }

    public static <T extends Number> double harmonicMean(final Collection<T> numbers) {
        final int count = numbers.size();
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform harmonic mean on an empty collection.");
        double reciprocalSum = 0.d;
        for (final T t : numbers)
            reciprocalSum += 1.d / t.doubleValue();
        return count / reciprocalSum;
    }

    public static double harmonicMean(final int[] ints) {
        final int count = ints.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform harmonic mean on an empty array.");
        double reciprocalSum = 0.d;
        for (final int i : ints)
            reciprocalSum += 1.d / i;
        return count / reciprocalSum;
    }

    public static double harmonicMean(final short[] shorts) {
        final int count = shorts.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform harmonic mean on an empty array.");
        double reciprocalSum = 0.d;
        for (final short s : shorts)
            reciprocalSum += 1.d / s;
        return count / reciprocalSum;
    }

    public static double harmonicMean(final byte[] bytes) {
        final int count = bytes.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform harmonic mean on an empty array.");
        double reciprocalSum = 0.d;
        for (final byte b : bytes)
            reciprocalSum += 1.d / b;
        return count / reciprocalSum;
    }

    public static double harmonicMean(final double[] doubles) {
        final int count = doubles.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform harmonic mean on an empty array.");
        double reciprocalSum = 0.d;
        for (final double d : doubles)
            reciprocalSum += 1.d / d;
        return count / reciprocalSum;
    }

    public static double harmonicMean(final float[] floats) {
        final int count = floats.length;
        if (count == 0)
            throw new IllegalArgumentException("Cannot perform harmonic mean on an empty array.");
        double reciprocalSum = 0.d;
        for (final float f : floats)
            reciprocalSum += 1.d / f;
        return count / reciprocalSum;
    }

    public static <T extends Number> double variance(final T[] numbers) {
        final int count = numbers.length;
        if (count < 2) throw new IllegalArgumentException(String.format("too few numbers (%d), expected >= 2.", count));
        final double arithmeticMean = arithmeticMean(numbers);
        double gapsSum = 0.d;
        for (final T number : numbers) gapsSum += pow((number.doubleValue() - arithmeticMean), 2.d);
        return gapsSum / (count - 1);
    }

    public static <T extends Number> double variance(final Collection<T> numbers) {
        final int count = numbers.size();
        if (count < 2) throw new IllegalArgumentException(String.format("too few numbers (%d), expected >= 2.", count));
        final double arithmeticMean = arithmeticMean(numbers);
        final double gapsSum = numbers.stream().mapToDouble(Number::doubleValue).map(a -> pow(a - arithmeticMean, 2.d)).sum();
        return gapsSum / (count - 1);
    }

    public static double variance(final int[] ints) {
        final int count = ints.length;
        if (count < 2) throw new IllegalArgumentException(String.format("too few numbers (%d), expected >= 2.", count));
        final double arithmeticMean = arithmeticMean(ints);
        double gapsSum = 0.d;
        for (final int i : ints) gapsSum += pow(i - arithmeticMean, 2.d);
        return gapsSum / (count - 1);
    }

    public static double variance(final short[] shorts) {
        final int count = shorts.length;
        if (count < 2) throw new IllegalArgumentException(String.format("too few numbers (%d), expected >= 2.", count));
        final double arithmeticMean = arithmeticMean(shorts);
        double gapsSum = 0.d;
        for (final short s : shorts) gapsSum += pow(s - arithmeticMean, 2.d);
        return gapsSum / (count - 1);
    }

    public static double variance(final byte[] bytes) {
        final int count = bytes.length;
        if (count < 2) throw new IllegalArgumentException(String.format("too few numbers (%d), expected >= 2.", count));
        final double arithmeticMean = arithmeticMean(bytes);
        double gapsSum = 0.d;
        for (final byte b : bytes) gapsSum += pow(b - arithmeticMean, 2.d);
        return gapsSum / (count - 1);
    }

    public static double variance(final double[] doubles) {
        final int count = doubles.length;
        if (count < 2) throw new IllegalArgumentException(String.format("too few numbers (%d), expected >= 2.", count));
        final double arithmeticMean = arithmeticMean(doubles);
        double gapsSum = 0.d;
        for (final double d : doubles) gapsSum += pow(d - arithmeticMean, 2.d);
        return gapsSum / (count - 1);
    }

    public static double variance(final float[] floats) {
        final int count = floats.length;
        if (count < 2) throw new IllegalArgumentException(String.format("too few numbers (%d), expected >= 2.", count));
        final double arithmeticMean = arithmeticMean(floats);
        double gapsSum = 0.d;
        for (final float f : floats) gapsSum += pow(f - arithmeticMean, 2.d);
        return gapsSum / (count - 1);
    }

    public static <T extends Number> long factorial(final T number) {
        if (number.intValue() < 0)
            throw new IllegalArgumentException("Cannot calculate factorial of a negative number.");
        if (number.intValue() == 0)
            return 1;
        long product = 1;
        for (int i = 1; i <= number.intValue(); i++)
            product *= i;
        return product;
    }

    public static long factorial(final int intValue) {
        if (intValue < 0)
            throw new IllegalArgumentException("Cannot calculate factorial of a negative number.");
        if (intValue == 0)
            return 1;
        long product = 1;
        for (int i = 1; i <= intValue; i++)
            product *= i;
        return product;
    }

    public static long factorial(final long longValue) {
        if (longValue < 0)
            throw new IllegalArgumentException("Cannot calculate factorial of a negative number.");
        if (longValue == 0)
            return 1;
        long product = 1;
        for (int i = 1; i <= longValue; i++)
            product *= i;
        return product;
    }

    public static long factorial(final short shortValue) {
        if (shortValue < 0)
            throw new IllegalArgumentException("Cannot calculate factorial of a negative number.");
        if (shortValue == 0)
            return 1;
        long product = 1;
        for (int i = 1; i <= shortValue; i++)
            product *= i;
        return product;
    }

    public static long factorial(final byte byteValue) {
        if (byteValue < 0)
            throw new IllegalArgumentException("Cannot calculate factorial of a negative number.");
        if (byteValue == 0)
            return 1;
        long product = 1;
        for (int i = 1; i <= byteValue; i++)
            product *= i;
        return product;
    }

    public static <T extends Number> double stdDeviation(final T[] numbers) {
        return sqrt(variance(numbers));
    }

    public static <T extends Number> double stdDeviation(final Collection<T> numbers) {
        return sqrt(variance(numbers));
    }

    public static double stdDeviation(final int[] ints) {
        return sqrt(variance(ints));
    }

    public static double stdDeviation(final short[] shorts) {
        return sqrt(variance(shorts));
    }

    public static double stdDeviation(final byte[] bytes) {
        return sqrt(variance(bytes));
    }

    public static double stdDeviation(final double[] doubles) {
        return sqrt(variance(doubles));
    }

    public static double stdDeviation(final float[] floats) {
        return sqrt(variance(floats));
    }

    public static class Mode<T extends Number> {
        private final T value;
        private final boolean isEmpty;

        private Mode(T value) {
            this.value = value;
            this.isEmpty = (value == null);
        }

        public T getValue() {
            return value;
        }

        public boolean isEmpty() {
            return isEmpty;
        }

        public void ifPresent(final Consumer<T> consumer) {
            if (isEmpty) return;
            consumer.accept(value);
        }

        public static <T extends Number> Mode<T> of(final T number) {
            return new Mode<T>(number);
        }
    }

    public static double mode(final double[] doubles) {
        final int count = doubles.length;
        if (count < 3) throw new IllegalArgumentException(String.format("too few numbers (%d), expected >= 3.", count));

        return 0; // to implement
    }

    public static class Range<T extends Number & Comparable<T>> {

        private T lowerBound;
        private T upperBound;

        private boolean lowerBoundInclusive = true;
        private boolean upperBoundInclusive = false;

        private Range(final T lowerBound, final T upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        public void setLowerBound(final T lowerBound) {
            this.lowerBound = lowerBound;
        }

        public void setUpperBound(final T upperBound) {
            this.upperBound = upperBound;
        }

        public void setLowerBoundInclusive(final boolean lowerBoundInclusive) {
            this.lowerBoundInclusive = lowerBoundInclusive;
        }

        public void setUpperBoundInclusive(final boolean upperBoundInclusive) {
            this.upperBoundInclusive = upperBoundInclusive;
        }

        public T getLowerBound() {
            return lowerBound;
        }

        public T getUpperBound() {
            return upperBound;
        }

        public boolean isLowerBoundInclusive() {
            return lowerBoundInclusive;
        }

        public boolean isUpperBoundInclusive() {
            return upperBoundInclusive;
        }

        public boolean isInRange(final T number) {
            if (lowerBound == null && upperBound == null) {
                return true;
            } else if (lowerBound == null) {
                final int upperCompare = number.compareTo(upperBound);
                return upperBoundInclusive ? (upperCompare < 1) : (upperCompare < 0);
            } else if (upperBound == null) {
                final int lowerCompare = number.compareTo(lowerBound);
                return lowerBoundInclusive ? (lowerCompare > -1) : (lowerCompare > 0);
            }
            final int upperCompare = number.compareTo(upperBound);
            final int lowerCompare = number.compareTo(lowerBound);
            return upperBoundInclusive ?
                    (lowerBoundInclusive ? (lowerCompare > -1 && upperCompare < 1) : (lowerCompare > 0 && upperCompare < 1))
                    : (lowerBoundInclusive ? (lowerCompare > -1 && upperCompare < 0) : (lowerCompare > 0 && upperCompare < 0));
        }

        public static <T extends Number & Comparable<T>> Range<T> build(final T lowerBound, final T upperBound) {
            return new Range<>(lowerBound, upperBound);
        }

    }

    public static class IntRange extends Range<Integer> {

        private IntRange(final Integer lowerBound, final Integer upperBound) {
            super(lowerBound, upperBound);
        }

        public void forEach(final IntConsumer consumer) {
            int start = isLowerBoundInclusive() ? getLowerBound() : getLowerBound() + 1;
            final int end = isUpperBoundInclusive() ? getUpperBound() : getUpperBound() - 1;
            while (start <= end) {
                consumer.accept(start);
                start++;
            }
        }

        public static IntRange build(final int lowerBound, final int upperBound) {
            return new IntRange(lowerBound, upperBound);
        }
    }

    public static class DoubleRange extends Range<Double> {

        private DoubleRange(final Double lowerBound, final Double upperBound) {
            super(lowerBound, upperBound);
        }

        public void forEach(final DoubleConsumer consumer, final double increase) {
            double start = isLowerBoundInclusive() ? getLowerBound() : getLowerBound() + increase;
            final double end = isUpperBoundInclusive() ? getUpperBound() : getUpperBound() - increase;
            while (start <= end) {
                consumer.accept(start);
                start += increase;
            }
        }

        public static DoubleRange build(final double lowerBound, final double upperBound) {
            return new DoubleRange(lowerBound, upperBound);
        }
    }

    public static boolean areSimilar(final double first, final double second, final double delta) {
        return Math.abs(second - first) <= delta;
    }
}
