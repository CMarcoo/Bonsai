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

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.currentTimeMillis;
import static org.junit.Assert.assertEquals;

public final class MeanTest {

    private static String timeTaken(final long then) {
        return " Time taken " + (currentTimeMillis() - then) + "ms.";
    }

    private static final ThreadLocalRandom rand = ThreadLocalRandom.current();
    private static final Double[] DOUBLES_SAMPLE = new Double[]{1d, 5d, 3d, 2d, 1d, 6d, 4d, 5d, 7d};
    private static final Collection<Double> DOUBLE_SAMPLE_COLLECTION = Arrays.asList(DOUBLES_SAMPLE);
    private static final Double DOUBLE_SAMPLE_ARITHMETIC_MEAN = 3.7777777777777777;

    @Test
    public void arithmeticMeanTest() {
        final long A1 = currentTimeMillis();
        final double meanA = Bonsai.arithmeticMean(DOUBLES_SAMPLE);
        System.out.println("Arithmetic mean (array): " + meanA + timeTaken(A1));
        assertEquals("Arithmetic mean is incorrect.", DOUBLE_SAMPLE_ARITHMETIC_MEAN, meanA, 0.000000000000001);
        final long A2 = currentTimeMillis();
        final double meanA2 = Bonsai.arithmeticMean(DOUBLE_SAMPLE_COLLECTION);
        System.out.println("Arithmetic mean (collection): " + meanA2 + timeTaken(A2));
        assertEquals("Arithmetic mean is incorrect.", DOUBLE_SAMPLE_ARITHMETIC_MEAN, meanA2, 0.000000000000001);
    }

    @Test
    public void arithmeticMeanBenchmark() throws InterruptedException {
        final Double[] sampleArray = new Double[1_000_000];
        final ArrayList<Double> sampleCollection = new ArrayList<>(1_000_000);
        for (int i = 0; i < 1_000_000; i++) {
            final double n = rand.nextDouble(1.d, 100d);
            sampleArray[i] = n;
            sampleCollection.add(i, n);
        }
        System.out.println("Array generation finished, sleeping 5 seconds...");
        Thread.sleep(5_000);
        System.out.println("Sleep finished, ready for benchmark:");
        final long b1 = currentTimeMillis();
        final double mean1 = Bonsai.arithmeticMean(sampleArray);
        System.out.println("Arithmetic mean (array): " + timeTaken(b1));

        final long b2 = currentTimeMillis();
        final double mean2 = Bonsai.arithmeticMean(sampleCollection);
        System.out.println("Arithmetic mean (collection): " + timeTaken(b2));
    }
}
