package com.company;

import java.io.*;

import static com.company.QuickSelect.*;
import static com.company.QuickSort.quickSort;

/**
 * Quickselect is a selection algorithm to find the kth smallest element in an
 * unordered list. Like quicksort, it is efficient in practice and has good
 * average-case performance, but has poor worst-case performance.
 * <p>
 * Quickselect uses the same overall approach as quicksort, choosing one
 * element as a pivot and partitioning the data in two based on the pivot,
 * accordingly as less than or greater than the pivot. However, instead of
 * recursing into both sides, as in quicksort, quickselect only recurses into
 * one side – the side with the element it is searching for. This reduces the
 * average complexity from O(n log n) (in quicksort) to O(n) (in quickselect).
 */

public class Main {
    public static void main(String[] args) {

        FileWriter o = null;
        try {
            o = new FileWriter("tests.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter out = new BufferedWriter(o);

        int[] sizes = {100, 500, 1000,
                5000, (int) 1e4, 25000, 50000, (int) 1e5, (int) 2.5e5, (int) 5e5, (int) 7.5e5, (int) 1e6,
                (int) 2e6, (int) 5e6};

        try {
            out.write("     Quickselect    Quicksort\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < sizes.length; i++) {

            try {
                out.write("Length: " + Integer.toString(sizes[i]) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

            double a1 = 0, a2 = 0;

            for (int j = 0; j < 10; j++) {

                int[] array = new int[sizes[i]];

                for (int k = 0; k < sizes[i]; k++)
                    array[k] = (int) (Math.random() * 100000);

                int[] array1 = array;

                long time = System.nanoTime();
                quickSelectSort(array);

                double x = ((System.nanoTime() - time) / 1e6);

                String t1 = Double.toString(x);

                a1 += x;

                time = System.nanoTime();
                quickSort(array1);

                x = ((System.nanoTime() - time) / 1e6);

                String t2 = Double.toString(x);

                a2 += x;

                try {
                    out.write("Test #" + Integer.toString(j + 1) + ":  " + t1 + "   " + t2 + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            String aa1 = Double.toString(a1 / 10.);
            String aa2 = Double.toString(a2 / 10.);

            try {
                out.write("Avarage:  " + aa1 + "   " + aa2 + "\n\n");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}