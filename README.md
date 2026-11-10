# Data Structures in Java

Classic data structures implemented from scratch in Java for my Data Structures course at Connecticut College, each with a test program that exercises it.

## What's here

| Structure | Implementation | Test program |
|-----------|----------------|--------------|
| Node | Building block that stores data and a link to the next node | `TestNode.java` |
| Linked list | `List.java` | `TestList.java` (sample output in `TestListOutput.txt`) |
| Stack (array-based) | `StackA.java` | `TestStackA.java` |
| Stack (linked list) | `StackLL.java` | `TestStackLL.java` |
| Queue (array-based) | `QueueA.java` | `TestQueueA.java` |
| Queue (linked list) | `QueueLL.java` | `TestQueueLL.java` |
| Binary search tree | `BST.java` | `TestBST.java` |

Implementing stacks and queues two ways (arrays and linked lists) shows the trade-offs between them: fixed capacity and fast indexing on one side, flexible size and cheap insertion on the other.

## Also included

- `HelloWorld.java`: a starter program
- `javascript-basics.js`: a runnable JavaScript cheat sheet covering variables, types, operators and more. Run it with `node javascript-basics.js`.

## How to run

Requires a Java JDK. Compile and run any test program, for example:

```bash
javac *.java
java TestBST
```

## Built with

- Java
