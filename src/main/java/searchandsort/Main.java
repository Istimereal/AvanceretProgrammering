package searchandsort;

import searchandsort.entities.Student;
import searchandsort.util.Factory;

import java.util.*;

public class Main {

    static HashSet<Integer> numbers = new HashSet<Integer>();

    static ArrayList<Integer> numberList = new ArrayList<>();
/*
    public static void main(String[] args) {
        // testComplexity();
       // testLinearAndBinarySearch();
       // testSort();

        int n = 10000; // justér for at demonstrere tydeligt

        long start = System.nanoTime();
        System.out.println(start);
        hashSet(n);
        long stop = System.nanoTime();
        System.out.println(stop);


        long start2 = System.nanoTime();
        System.out.println("2- " + start2);
        addHashSet(1000);
        long stop2 = System.nanoTime();
        System.out.println("2- " + stop2);

    }

    */
/*
    public static void main(String[] args) {
        int n = 10000;
        int target = 3333;

        measureInsertArrayList(n);
        measureInsertHashSet(n);
        measureSearchArrayList(target);
        measureSearchHashSet(target);
    }

    */

    public static void main(String[] args) {
        int n = 10000;
        int extra = 1000;
        int target = 10000;

   /*     measureHashSet(n);
        measureAddHashSet(extra);
        measureSearchHashSet(target);

        measureArrayList(n);
        measureAddArrayList(extra);
        measureSearchArrayList(target);
*/

        //  testComplexity();
        // testLinearAndBinarySearch();
       //  testBubble(10, true, true);
          testMerge(10, true, true);
      //  testQuick(50000, true,true);
      /*  Student[] arr = createCardArray();
       printArray("Før sortering", arr);
       List<Student> cards = Arrays.asList(arr); */
        // SortExamples.quickSort(cards, 0, cards.size()-1);
        // SortExamples.mergeSort(arr);
        // printArray("Efter sortering", arr);
        //SortExamples.recursiveCall(10);
    }

    public static void measureInsertArrayList(int n) {
        numberList.clear();

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            numberList.add(i);
        }
        long stop = System.nanoTime();

        System.out.println("ArrayList insert: " + (stop - start) + " ns");
    }

    public static void measureInsertHashSet(int n) {
        numbers.clear();

        long start = System.nanoTime();
        for (int i = 0; i < n; i++) {
            numbers.add(i);
        }
        long stop = System.nanoTime();

        System.out.println("HashSet insert: " + (stop - start) + " ns");
    }

    public static void measureSearchArrayList(int target) {
        long start = System.nanoTime();
        boolean found = numberList.contains(target);
        long stop = System.nanoTime();

        System.out.println("ArrayList contains(" + target + "): " + found + " - " + (stop - start) + " ns");
    }

    public static void measureSearchHashSet(int target) {
        long start = System.nanoTime();
        boolean found = numbers.contains(target);
        long stop = System.nanoTime();

        System.out.println("HashSet contains(" + target + "): " + found + " - " + (stop - start) + " ns");

    }

    /// ///////////////////////////////////////////////////////////// nyt
    public static void addArrayList(int n) {
        for (int i = 10000; i < 10000 + n; i++) {
            numberList.add(i);
            numberList.add(i * i);
        }
    }

    public static void arrayList(int n) {
        for (int i = 0; i < n; i++) {
            numberList.add(i);
            numberList.add(i * i);
        }
    }

    public static void measureHashSet(int n) {
        numbers.clear();

        long start = System.nanoTime();
        hashSet(n);
        long stop = System.nanoTime();

        System.out.println("hashSet(" + n + "): " + (stop - start) + " ns");
    }

    public static void measureAddHashSet(int n) {
        long start = System.nanoTime();
        addHashSet(n);
        long stop = System.nanoTime();

        System.out.println("addHashSet(" + n + "): " + (stop - start) + " ns");
    }

    public static void measureArrayList(int n) {
        numberList.clear();

        long start = System.nanoTime();
        arrayList(n);
        long stop = System.nanoTime();

        System.out.println("arrayList(" + n + "): " + (stop - start) + " ns");
    }

    public static void measureAddArrayList(int n) {
        long start = System.nanoTime();
        addArrayList(n);
        long stop = System.nanoTime();

        System.out.println("addArrayList(" + n + "): " + (stop - start) + " ns");
    }


    public static void addHashSet(int n) {
        for (int i = 10000; i < 10000 + n; i++) {
            numbers.add(i);
            numbers.add(i*i);
        }
    }


    public static void hashSet(int n) {
        for (int i = 0; i < n; i++) {
            numbers.add(i);
            numbers.add(i*i);
        }
    }

    private static void testComplexity() {
        int n = 10000; // justér for at demonstrere tydeligt

     /*
        // O(1)
        long start = System.currentTimeMillis();
        BigOExamples.constantTime(n);
        long stop = System.currentTimeMillis();
        System.out.println("Time for O(1): " + (stop - start) + " ms\n");

        // O(log n)
        start = System.currentTimeMillis();
        BigOExamples.logTime(n);
        stop = System.currentTimeMillis();
        System.out.println("Time for O(log n): " + (stop - start) + " ms\n");

        // O(n)
        start = System.currentTimeMillis();
        BigOExamples.linearTime(n);
        stop = System.currentTimeMillis();
        System.out.println("Time for O(n): " + (stop - start) + " ms\n");

        // O(n²) - pas på med at vælge et for stort n!
      //  n = 2000; // mindre n for kvadratisk!
        start = System.currentTimeMillis();
        BigOExamples.quadraticTime(n);
        stop = System.currentTimeMillis();
        System.out.println("Time for O(n²): " + (stop - start) + " ms\n");

        */
    }

    private static void testLinearAndBinarySearch() {
        List<Student> students = new ArrayList<>();
        Factory.fillWithStudents(students, 100000);

        int targetId = 99999; // sidst i listen, så forskellen er tydelig!

        // Lineær søgning
        long start = System.currentTimeMillis();
        Student studentLinear = SearchExamples.linearSearch(students, targetId);
        long stop = System.currentTimeMillis();
        System.out.println("Lineær søgning fandt: " + studentLinear);
        System.out.println("Tid: " + (stop - start) + " ms");

        // Sorter listen efter ID (nødvendigt for binær søgning)
        // Hvad sorteres de studerende efter? Hvordan finder vi ud af det?
        Collections.sort(students);

        // Binær søgning
        start = System.currentTimeMillis();
        Student studentBinary = SearchExamples.binarySearch(students, targetId);
        stop = System.currentTimeMillis();
        System.out.println("Binær søgning fandt: " + studentBinary);
        System.out.println("Tid: " + (stop - start) + " ms");
    }


    private static void testBubble(int size, boolean time, boolean print) {
        List<Student> list = new ArrayList<>();
        Factory.fillWithStudents(list, size);
        Collections.shuffle(list);
        if (print) printList("Bubble Sort - før", list);
        long start = System.currentTimeMillis();
        SortExamples.bubbleSort(list);
        long stop = System.currentTimeMillis();
        if (print) printList("Bubble Sort - efter", list);
        if (time) System.out.println("Bubble Sort - tid: " + (stop - start) + " ms");
    }

    private static void testHeap(int size, boolean time, boolean print) {
        List<Student> list = new ArrayList<>();
        Factory.fillWithStudents(list, size);
        Collections.shuffle(list);
        if (print) printList("Heap Sort - før", list);
        long start = System.currentTimeMillis();
        SortExamples.heapSort(list);
        long stop = System.currentTimeMillis();
        if (print) printList("Heap Sort - efter", list);
        if (time) System.out.println("Heap Sort - tid: " + (stop - start) + " ms");
    }

    private static void testQuick(int size, boolean time, boolean print) {
        List<Student> list = new ArrayList<>();
        Factory.fillWithStudents(list, size);
        //Collections.shuffle(list);
        if (print) printList("Quick Sort - før", list);
        long start = System.currentTimeMillis();
        SortExamples.quickSort(list, 0, list.size() - 1);
        long stop = System.currentTimeMillis();
        if (print) printList("Quick Sort - efter", list);
        if (time) System.out.println("Quick Sort - tid: " + (stop - start) + " ms");
    }

    private static void testMerge(int size, boolean time, boolean print) {
        List<Student> original = new ArrayList<>();
        Factory.fillWithStudents(original, size);
        Collections.shuffle(original);
        Student[] mergearray = original.toArray(new Student[0]);
        if (print) printArray("Merge Sort - før", mergearray);
        long start = System.currentTimeMillis();
        SortExamples.mergeSort(mergearray);
        long stop = System.currentTimeMillis();
        if (print) printArray("Merge Sort - efter", mergearray);
        if (time) System.out.println("Merge Sort - tid: " + (stop - start) + " ms");
    }

    // Hjælpemetoder til udskrift
    private static void printList(String label, List<Student> list) {
        System.out.println(label + ": ");
        for(Student s:list){
            System.out.println(s);
        }
    }

    private static void printArray(String label, Student[] arr) {
        System.out.println(label + ": ");
        for(Student s:arr){
            System.out.println(s);
        }
    }

    private static Student[] createCardArray(){
        Student[] arr = new Student[6];
        arr[0] =  new Student("Tre", 3);
        arr[1] = new Student("Ni", 9);
        arr[2] = new Student("Syv", 7);
        arr[3] = new Student("10", 10);
        arr[4] = new Student("Dronning", 12);
        arr[5] = new Student("Fire", 4);
        return arr;
    }

    /*
    private static void testSort() {
        List<Student> original = new ArrayList<>();
        Factory.fillWithStudents(original, 100000); // eller fx 10_000 til hurtigere test
      //  Collections.shuffle(original);

        // Bubble Sort (langsom)
        List<Student> bubbleList = new ArrayList<>(original);
        long start = System.currentTimeMillis();
     //   SortExamples.bubbleSort(bubbleList);
        long stop = System.currentTimeMillis();
        System.out.println("Bubble Sort - tid: " + (stop - start) + " ms");

        // Heap Sort
        List<Student> heapList = new ArrayList<>(original);
        start = System.currentTimeMillis();
        SortExamples.heapSort(heapList);
        stop = System.currentTimeMillis();
        System.out.println("Heap Sort - tid: " + (stop - start) + " ms");

        // Quick Sort
        List<Student> quickList = new ArrayList<>(original);
        start = System.currentTimeMillis();
        SortExamples.quickSort(quickList, 0, quickList.size() - 1);
        stop = System.currentTimeMillis();
        System.out.println("Quick Sort - tid: " + (stop - start) + " ms");

        // Merge Sort
        List<Student> mergeList = new ArrayList<>(original);
        start = System.currentTimeMillis();
        SortExamples.mergeSort(mergeList);
        stop = System.currentTimeMillis();
        System.out.println("Merge Sort - tid: " + (stop - start) + " ms");
    }
*/
}
