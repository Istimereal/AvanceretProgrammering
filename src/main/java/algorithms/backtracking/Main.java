package algorithms.backtracking;

import searchandsort.SortExamples;

public class Main {

    public static void main(String[] args) {


      long start = System.currentTimeMillis();

     // long start = System.nanoTime();

        //  NQueens.placeQueen(0);
        TQueens.placeQueen(0);

        long stop = System.currentTimeMillis();
       // long stop = System.nanoTime();

        System.out.println("Solve time: " + (stop - start) + " sekunder");
    }

}
