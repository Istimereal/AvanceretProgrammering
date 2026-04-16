package searchandsort;

import java.util.HashSet;

public class BigOExamples {

   static HashSet<Integer> numbers = new HashSet<Integer>();

    public static void main(String[] args) {
    /*    int n = 10; // Juster n for at se effekten
        System.out.println("O(1) - Konstant tid:");
        constantTime(n);

        System.out.println("\nO(log n) - Logaritmisk tid:");
        logTime(n);

        System.out.println("\nO(n) - Lineær tid:");
        linearTime(n);

        System.out.println("\nO(n^2) - Kvadratisk tid:");
        quadraticTime(n);
*/
        logTimeUp( 5);
    }

    public static void hashSet(int n) {
        for (int i = 0; i < n; i++) {
           numbers.add(i);
        }
    }

    // O(1) - Konstant tid
    public static void constantTime(int n) {
        System.out.println("Jeg printer altid én gang, uanset n.");
    }

    // O(log n) - Logaritmisk tid (Binær nedtælling)
    public static void logTime(int n) {
        for (int i = n; i > 1; i /= 2) {
            System.out.println("Jeg kører log n gange, n er nu: " + i);
        }
    }

    // O(log n) - Logaritmisk tid (Binær optælling)
    public static void logTimeUp(float n) {
        for (float i = 1; i < n; i *= 2) {
            System.out.println("Jeg kører log n gange, n er nu: " + i);
        }
    }

    // O(n) - Lineær tid
   public static void linearTime(int n) {
         for (int i = 0; i < n; i++) {
            System.out.println("Itererer: " + i);
        }
    }

    // O(n^2) - Kvadratisk tid
    public static void quadraticTime(int n) {

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Kvadratisk iteration: " + i + "," + j);
            }
        }

    }
}

