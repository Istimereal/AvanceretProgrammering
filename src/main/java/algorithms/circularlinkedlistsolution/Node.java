package algorithms.circularlinkedlistsolution;

public class Node {
    int value;
    Node next;

  public Node(int value) {
        this.value = value;
    }

    public String toString(){
        String result = "" + value;
        if (next != null){
            result += " -> " + next.toString();
        }
        return result;
    }
}
