package Afleveringer;

import java.util.HashSet;
import java.util.TreeSet;

public class CompareSets {
    static TreeSet<EntityWithComparable> testTreeSet = new TreeSet<>();
    static HashSet<EntityWithComparable> testHashsetComparable = new HashSet<>();

    public static void main(String[] args) {
      int amount = 500000;

        long startFillTree = System.nanoTime();
        fillTreeSet(amount);
        long stopFillTree = System.nanoTime();
        System.out.println("Fill TreeSet totalTime nanoseconds: " + (stopFillTree - startFillTree));


        long startFillHash = System.nanoTime();
        fillHashSet(amount);
        long stopFillHash = System.nanoTime();
        System.out.println("Fill HashSet totalTime nanoseconds: " + (stopFillHash - startFillHash));


        // Add
        for (int i = amount; i < amount + 100; i++) {
            EntityWithComparable entity = new EntityWithComparable(i);
            long startAddTree = System.nanoTime();
            addEntityToTreeSet(entity);
            long stopAddTree = System.nanoTime();
            System.out.println("TreeSet add at index totalTime nanoseconds: " + (stopAddTree - startAddTree));
            long startAddHash= System.nanoTime();
            addEntityToHashSet(entity);
            long stopAddHash = System.nanoTime();
            System.out.println("HashSet add at index totalTime nanoseconds: " + (stopAddHash - startAddHash));
        }

        // Find
        for (int i = amount; i < amount + 100; i++) {
            EntityWithComparable entity = new EntityWithComparable(i);
            long startFindTree = System.nanoTime();
            findInTreeSet(entity);
            long stopFindTree = System.nanoTime();
            System.out.println("TreeSet find objects totalTime nanoseconds: " + (stopFindTree - startFindTree));

            long startFindHash = System.nanoTime();
            findInHashSet(entity);
            long stopFindHash = System.nanoTime();
            System.out.println("HashSet find objects totalTime nanoseconds: " + (stopFindHash - startFindHash));
        }

        //Remove
        for (int i = amount; i < amount + 100; i++) {
            EntityWithComparable entity = new EntityWithComparable(i);

            long startRemoveTree = System.nanoTime();
            removeFromTreeSet(entity);
            long stopRemoveTree = System.nanoTime();
            System.out.println("TreeSet remove objects totalTime nanoseconds: " + (stopRemoveTree - startRemoveTree));

            long startRemoveHash = System.nanoTime();
            removeFromHashSet(entity);
            long stopRemoveHash = System.nanoTime();
            System.out.println("HashSet remove objects totalTime nanoseconds: " + (stopRemoveHash - startRemoveHash));
        }

    }

    public static void fillTreeSet(int amount) {
        for (int i = 0; i < amount; i++) {
            testTreeSet.add(new EntityWithComparable(i));
        }
    }

    public static void fillHashSet(int amount) {
        for (int i = 0; i < amount; i++) {
            testHashsetComparable.add(new EntityWithComparable(i));
        }
    }

    public static void addEntityToTreeSet(EntityWithComparable entity){

        testTreeSet.add(entity);
    }

    public static Boolean removeFromTreeSet(EntityWithComparable entity){

        boolean removed = testTreeSet.remove(entity);
        return  removed;
    }

    public static boolean findInTreeSet(EntityWithComparable entity){

        boolean find = testTreeSet.contains(entity);

        return find;
    }

    public static void addEntityToHashSet(EntityWithComparable entity){

        testHashsetComparable.add(entity);
    }

    public static Boolean removeFromHashSet(EntityWithComparable entity){

        boolean removed = testHashsetComparable.remove(entity);

     return removed;
    }

    public static boolean findInHashSet(EntityWithComparable entity){

        boolean find = testHashsetComparable.contains(entity);
        return find;
    }

}