/* Array-based Stack Implementation

This class creates an array-based stack that has the methods
push, pop, top, isEmpty, printStack, and createEmptyStack

Rowan Karaca - October 22 2026

*/


public class StackA {
    private Node[] head;
    private int n;

    public StackA() {
        head = new Node[100];
        n = 0;
    }
    public void push(Node value) {
        if(n < 100) {
            head[n] = value;
            n++;
        } else {
            System.out.println("Stack is full");
        }
    }
    public Node pop() {
        if(n > 0) {
            n--;
            return head[n];
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }
    public Node top() {
        if(n > 0) {
            return head[n-1];
        } else {
            System.out.println("Stack is empty");
            return null;
        }
    }
    public boolean isEmpty() {
        return n == 0;
    }
    public void createEmptyStack() {
        n = 0;
    }
    public void printStack() {
        System.out.println(n);
        for(int i = n-1; i >= 0; i--) {
            System.out.println(head[i].getKey());
        }
    }

}
