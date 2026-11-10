/* Linked List-based Stack Implementation

This program implements a stack using a linked list structure, using
the same methods as the array-based stack implementation. The methods include
push, pop, top, isEmpty, printStack, and createEmptyStack.

Rowan Karaca - October 22 2026

*/

public class StackLL {

    private Node head;
    private int n;

    public StackLL() {
        head = null;
        n = 0;
    }
    public void push(Node value) {
        value.setNext(head);
        head = value;
        n++;
    }
    public Node pop() {
        if(n > 0) {
            Node temp = head;
            head = head.getNext();
            n--;
            return temp;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }
    public Node top() {
        if(n > 0) {             
            return head;
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public void createEmptyStack() {
        head = null;
        n = 0;
    }
    public int size() {
        return n;
    }   
    public void printStack() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.getKey());
            temp = temp.getNext();
        }
    }

}
