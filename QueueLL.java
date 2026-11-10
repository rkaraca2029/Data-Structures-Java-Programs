/* This program implements a queue using a linked list

The following functions are implemented:
- enqueue: Adds an element to the rear of the queue
- dequeue: Removes an element from the front of the queue
- isEmpty: Checks if the queue is empty
- front: Returns the element at the front of the queue.    
- printQueue: Prints the key of each element in the queue 

Rowan Karaca, October 25, 2026

*/

public class QueueLL {
    private Node head;
    private Node tail;

    public QueueLL() {
        this.head = null;
        this.tail = null;
    }
    
    public void enqueue(Node x) {
        x.setNext(null);
        if (tail != null) {
            tail.setNext(x);
        }
        tail = x;
        if (head == null) {
            head = tail;
        }
    }

    public Node dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        Node temp = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        }
        return temp;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node front() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return null;
        }
        return head;
    }

    public void printQueue() {
        Node current = head;
        while (current != null) {
            System.out.println(current.getKey());
            current = current.getNext();
        }
    }

}
