package Afleveringer;

import java.util.ArrayList;
import java.util.LinkedList;

public class DatastrukturerOgKompleksitet {

    static ArrayList<Integer> testArrayList = new ArrayList();
    static LinkedList<Integer> testLinkedList = new LinkedList();

    public static void main(String[] args) {

        fillArraylist(500000);
        fillLinkedList(500000);

    int arrayListResult = getIndexArrayList(250000);

        System.out.println("ArrayList Get result: " + arrayListResult);


     int linkedListResult = getIndexLinkedList(250000);
        System.out.println("LinkedList Get result: " + linkedListResult);

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

        System.out.println("ArrayList start time namo: " + start);
        System.out.println("ArrayList stop time namo: " + stop);

        System.out.println("ArrayList get totalTime: " + (stop - start));

        return result;
    }

    public static int getIndexLinkedList(int n) {
        long start = System.nanoTime();

        int result = testLinkedList.get(n);
        long stop = System.nanoTime();
        System.out.println("LinkedList start time namo: " + start);
        System.out.println("LinkedList stop time namo: " + stop);

        System.out.println("LinkedList get totalTime: " + (stop - start));

        return result;
    }
}
