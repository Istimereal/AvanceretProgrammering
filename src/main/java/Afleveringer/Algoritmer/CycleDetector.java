package Afleveringer.Algoritmer;

import algorithms.circularlinkedlist.Node;

import static algorithms.circularlinkedlist.ListFactory.buildList;
import static algorithms.circularlinkedlist.ListFactory.buildListWithCycle;

import java.util.List;

public class CycleDetector {


    // *** SE afleveringer/docs/cykliskListe.drawio.pgn For LISTEN  ***

    public static void main(String[] args) {

    //  Node listToInvestigate =  buildList(1, 2, 3, 2);
        //  boolean result = hasCycle(listToInvestigate);
        //boolean result = hasCycle(listToInvestigate);

        Node cycleList = buildListWithCycle();
        boolean result = hasCycle(cycleList);


      System.out.println("Er listen cyclisk: " + result);

    }

    public static boolean hasCycle(Node head) {

        if (head == null) return false;

        Node fast = head;
        Node slow = head;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;

            if (fast == null) return false;

            fast = fast.next;

            if (slow == null) return false;

            if (fast == null) return false;

            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

//Bonusopgave: Kan du forudse hvad floydexample.TraversingArrays.hasCycle(..) vil returnere med
// inputtet int[] test = {2, 0, 1} og hvorfor?
//returnerer true da de begge går fra index 0 til 2 til 1, så begge looper
