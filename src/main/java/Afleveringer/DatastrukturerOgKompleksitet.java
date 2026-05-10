package Afleveringer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class DatastrukturerOgKompleksitet {

    static ArrayList<Integer> testArrayList = new ArrayList();
    static LinkedList<Integer> testLinkedList = new LinkedList();
    static HashSet<Integer> testHashset = new HashSet<>();


    public static void main(String[] args) {

        fillArraylist(500000);
        fillLinkedList(500000);
        fillHashSet(500000);

//    int arrayListResult = getIndexArrayList(250000);

  //   int linkedListResult = getIndexLinkedList(250000);

addToArrayList(250000, 99);
addLinkedList(250000, 99);

removeArrayList(250000);
removeLinkedList(250000);


        // exist
        boolean resultArrayList =  findInArrayList(250000);
        System.out.println("ArrayList contains?" + resultArrayList);
        boolean result = findInHashSet(250000);
        System.out.println("HashSet contains? " + result);

        // doesn´t contain
    boolean resultArrayList2 = findInArrayList(500001);
        System.out.println("ArrayList contains?" + resultArrayList2);
    boolean result2 =  findInHashSet(500001);
        System.out.println("HashSet contains? " + result2);




    }

    public static void fillArraylist(int n) {
        for (int i = 0; i < n; i++) {
            testArrayList.add(i);
        }
    }

    public static void fillLinkedList(int n) {
        for (int i = 0; i < n; i++) {
            testLinkedList.add(i);
        }
    }

    public static int getIndexArrayList(int n) {
        long start = System.nanoTime();

        int result = testArrayList.get(n);
        long stop = System.nanoTime();

        System.out.println("ArrayList get totalTime: " + (stop - start));

        return result;
    }

    public static void addToArrayList(int index, int value){
        long start = System.nanoTime();
        testArrayList.add(index, value);
        long stop = System.nanoTime();
        System.out.println("ArrayList add at index totalTime nanoseconds: " + (stop - start));
    }

    public static void removeArrayList(int index){

        long start = System.nanoTime();
        testArrayList.remove(index);
        long stop = System.nanoTime();
        System.out.println("ArrayList remove index totalTime nanoseconds: " + (stop - start));

    }

    public static Boolean findInArrayList(int n){

        if(testArrayList.contains(n)){
            return true;
        }
        else{ return false; }
    }

    public static int getIndexLinkedList(int n) {
        long start = System.nanoTime();
        long start2 = System.currentTimeMillis();

        int result = testLinkedList.get(n);
        long stop = System.nanoTime();
        long stop2 = System.currentTimeMillis();
        System.out.println("LinkedList get totalTime nanoseconds: " + (stop - start));
        System.out.println("LinkedList get totalTime milliseconds: " + (stop2 - start2));

        return result;
    }

    public static void addLinkedList(int index, int value){

        long start = System.nanoTime();
        testLinkedList.add(index, value);
        long stop = System.nanoTime();
        System.out.println("LinkedList add at index totalTime milliseconds: " + (stop - start));
    }

    public static void removeLinkedList(int index){

        long start = System.nanoTime();
        testLinkedList.remove(index);
        long stop = System.nanoTime();
        System.out.println("LinkedList remove index totalTime milliseconds: " + (stop - start));

    }

    public static void fillHashSet(int n){

        for (int i = 0; i<n; i++){

            testHashset.add(i);
        }
    }

    public static Boolean findInHashSet(int n){

        if(testHashset.contains(n)){
            return true;
        }
        else{ return false; }
    }
}
