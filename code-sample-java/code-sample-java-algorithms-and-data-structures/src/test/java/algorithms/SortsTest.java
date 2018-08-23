package algorithms;

import codesample.algorithms.Sorts;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class SortsTest {

    private final int size = 50000;
    private final int randomSeed = 0;
    private Random rnd;

    private Comparable<Integer>[] arrTest;
    private Comparable<Integer>[] arrExp;

    @Before
    public void setRandomSeed() {
        rnd = new Random(randomSeed);
    }

    @Before
    public void initiateArrays() {
        arrTest = generateRandomIntegerArray(size);
        arrExp = arrTest.clone();
    }

    @Test
    public void insertionSortTest() {

        Sorts.insertionSort(arrTest, 0, size);
        Arrays.sort(arrExp);

        Assert.assertArrayEquals(arrTest, arrExp);
    }

    @Test
    public void selectionSortTest() {
        int bob = 1;
        Sorts.selectionSort(arrTest, 0, size);
        Arrays.sort(arrExp);

        Assert.assertArrayEquals(arrTest, arrExp);
    }

    @Test
    public void shellSortTest() {
        Sorts.shellSort(arrTest, 0, size);
        Arrays.sort(arrExp);

        Assert.assertArrayEquals(arrTest, arrExp);
    }

    private Integer[] generateRandomIntegerArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i<size; ++i) {
            array[i] = rnd.nextInt();
        }
        return array.clone();
    }
}
