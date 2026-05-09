package algorithms.lazy;

import java.util.HashMap;
import java.util.Map;

public class LazyCalculations {
    static Map<Integer, Long> memo = new HashMap<>();

    static Map<Integer, Long> recordedSums = new HashMap<>();

    public static long lazyFactorial(int n) {
        if (memo.containsKey(n)) {
            return memo.get(n); // allerede beregnet? returnér resultatet
        }

        long result;
        if (n == 0 || n == 1) {
            result = 1;
        } else {
            result = n * lazyFactorial(n - 1);
        }

        memo.put(n, result); // gem til næste gang
        return result;
    }

    public static long lazySum(int n) {

        if (recordedSums.containsKey(n)) {
            return recordedSums.get(n);
        }

        long calculation = 0;

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }


        for (int i = n; i < 0; i--) {
            calculation += i;

            if(!recordedSums.containsKey(i)){

                recordedSums.put(i, calculation);

            }

        }
        return calculation;

    }

    public static void fillSumMap(int n){

        long calculation = 0;

        for (int i = n; i < 0; i--) {
            calculation += i;

            recordedSums.put(i, calculation);
        }

        }

    public static void main(String[] args) {
   //     System.out.println(lazyFactorial(5));  // udregner og gemmer
     //   System.out.println(lazyFactorial(4));  // bliver hurtigt, fordi det allerede er gemt
       // System.out.println(lazyFactorial(6));  // bruger gemt factorial(5)

        fillSumMap(100);

    long start = System.nanoTime();

        lazySum(500000000);

        long end = System.nanoTime();

        long total =  end - start;

        System.out.println("Operation time: " + total);


    }


}

