/* This program creates an unordered linked list of nodes
with a set of methods for manipulating the list

The methods: length(), isEmptyList(), searchReturn(), searchRemove(), insert(), printList() 

Rowan Karaca - October 22 2026

*/

public class List {

    private Node head;
    private int n;

    public List() {
        this.head = null;
        this.n = 0;
    }
    public int length() {
        return n;
    }
    public boolean isEmptyList() {
        return n == 0;
    }
    public Node searchReturn(int key) {
        Node current = head;
        while (current != null) {
            if (current.getKey() == key) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }
    public Node searchRemove(int key) {
        if (head == null) {
            return null;
        }
        Node temp1 = head;
        Node temp2 = temp1.getNext();

        if (temp1.getKey() == key) {
            n--;
            head = temp1.getNext();
            temp1.setNext(null);
            return temp1;
        }
        while (temp2 != null) {
            if (temp2.getKey() == key) {
                temp1.setNext(temp2.getNext());
                temp2.setNext(null);
                n--;
                return temp2;
            }
            temp1 = temp2;
            temp2 = temp2.getNext();
        }
        return null;
    }
    public void insert(Node value) {
        value.setNext(head);
        head = value;
        n++;
    }
    public void printList() {
        System.out.println(n);
        Node current = head;
        while (current != null) {
            System.out.println(current.getKey());
            current = current.getNext();
        }
    }

}