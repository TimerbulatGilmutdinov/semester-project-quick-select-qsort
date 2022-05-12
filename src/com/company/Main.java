package com.company;

import static com.company.QuickSelect.quickSelectIterative;
import static com.company.QuickSelect.quickSelectRecursive;

/**
 *	Quickselect is a selection algorithm to find the kth smallest element in an
 *	unordered list. Like quicksort, it is efficient in practice and has good
 *	average-case performance, but has poor worst-case performance.
 *
 *	Quickselect uses the same overall approach as quicksort, choosing one
 *	element as a pivot and partitioning the data in two based on the pivot,
 *	accordingly as less than or greater than the pivot. However, instead of
 *	recursing into both sides, as in quicksort, quickselect only recurses into
 *	one side – the side with the element it is searching for. This reduces the
 *	average complexity from O(n log n) (in quicksort) to O(n) (in quickselect).
 *
 */

public class Main {
    public static void main(String[] args) {
        int[] array = {9, 8, 7, 6, 5, 0, 1, 2, 3, 4};
        for(int i = 0; i < array.length; i++) {
            System.out.print(quickSelectIterative(array, i)+" ");
        }
        System.out.println();
        for(int i = 0; i < array.length; i++) {
            System.out.print(quickSelectRecursive(array, i)+" ");
        }
    }
}