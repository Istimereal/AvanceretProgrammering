package Afleveringer;

import searchandsort.SortExamples;
import searchandsort.entities.Student;
import searchandsort.util.Factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import java.util.*;


public class Sortering {


   static int count = -1;

    public static void main(String[] args) {

  //      int[] arr = makeRandomArray(10);

     //   bubbleSortAray(arr);

        testBubble(800);

    }

    private static void testBubble(int size) {
       int[] test = makeRandomArray(size);

         System.out.println("Merge Sort - før " + Arrays.toString(test));
        long start = System.currentTimeMillis();    //System.nanoTime();
        mergeSortArray(test);
        long stop = System.currentTimeMillis();      // System.nanoTime();

        System.out.println("Merge Sort - efter" + Arrays.toString(test));
       System.out.println("Merge Sort - tid: " + (stop - start) + " nano sekunder");
    }


    public static void mergeSortArray(int[] arr){
      count += 1;

        int size = arr.length;
        if(size < 2){ return;}

        int left = size/2;
        int right = size - left;

        int[] leftside = new int[left];
        int[] rightside = new int[right];

        for(int i = 0; i < left; i++){
            leftside[i] = arr[i];
        }

        for(int i = 0; i < right; i++){
            rightside[i] = arr[left + i];
        }

        mergeSortArray(leftside);
        mergeSortArray(rightside);

        mergeArray(arr, leftside, rightside);
    }

    public static void mergeArray(int[] arr, int[] left, int [] right){

        int i = 0, l = 0, r = 0;

        while(l < left.length && r < right.length)
        {
            if(left[l] <= right[r]){

                arr[i] = left[l];
                l++;
                i++;
            }
            else{
                arr[i] = right[r];
                r++;
                i++;
            }
            }

            while(l < left.length){

                arr[i] = left[l];
                l++;
                i++;
            }


            while (r < right.length) {


                arr[i] = right[r];
                r++;
                i++;
            }
    }

    public static void bubbleSortAray(int[] arr)
    {

        int size = arr.length;

for(int i = 0; i< size - 1; i++) {

    for(int j = 0; j < size - i - 1; j++){

        if(arr[j] > arr[j + 1]){
            swap(arr, i, j);
        }
    }
}
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] makeRandomArray(int n) {
        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }

        Random random = new Random();

        // Blander arrayet ved at bytte hvert element med et tilfældigt andet element
        for (int i = 0; i < arr.length; i++) {
            int randomIndex = random.nextInt(arr.length);
            swap(arr, i, randomIndex);
        }

        return arr;
    }
}
