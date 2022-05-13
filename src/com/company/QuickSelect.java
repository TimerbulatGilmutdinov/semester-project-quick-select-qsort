package com.company;

public class QuickSelect {
    public static void quickSelectSort(int[] array){
        for(int i = 0; i < array.length; i++) {
            quickSelectIterative(array, i);
        }
    }

    public static void quickSelectIterative(int[] array, int n) {
        quickSelectIterativeHelper(array, 0, array.length - 1, n);
    }

    private static void quickSelectIterativeHelper(int[] array, int left, int right, int n) {
        if(left == right) {
            return;
        }

        while(true) {
            int pivotIndex = randomPivot(left, right);
            pivotIndex = partition(array, left, right, pivotIndex);

            if(n == pivotIndex) {
                return;
            } else if(n < pivotIndex) {
                right = pivotIndex - 1;
            } else {
                left = pivotIndex + 1;
            }
        }
    }


    /**
     *	In quicksort, there is a subprocedure called partition that can, in
     *	linear time, group a list (ranging from indices left to right) into two
     *	parts, those less than a certain element, and those greater than or
     *	equal to the element.
     */
    private static int partition(int[] array, int left, int right, int pivotIndex) {
        int pivotValue = array[pivotIndex];
        swap(array, pivotIndex, right);
        int storeIndex = left;
        for(int i = left; i < right; i++) {
            if(array[i] < pivotValue) {
                swap(array, storeIndex, i);
                storeIndex++;
            }
        }
        swap(array, right, storeIndex);
        return storeIndex;
    }

    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    private static int randomPivot(int left, int right) {
        return left + (int) Math.floor(Math.random() * (right - left + 1));
    }
}
