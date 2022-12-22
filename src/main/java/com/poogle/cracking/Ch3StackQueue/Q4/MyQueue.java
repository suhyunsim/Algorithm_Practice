package main.java.com.poogle.cracking.Ch3StackQueue.Q4;

import java.util.Stack;

public class MyQueue<T> {
    /*
    stackNewest: new -> top (inBox) add
    stackOldest: last -> top (outBox) peek, poll
     */
    Stack<T> stackNewest, stackOldest;

    public MyQueue() {
        stackNewest = new Stack<>();
        stackOldest = new Stack<>();
    }

    public int size() {
        return stackNewest.size() + stackOldest.size();
    }

    public void add(T value) {
        // new -> top
        stackNewest.push(value);
    }

    // move newest -> oldest
    private void shiftStacks() {
        if (stackOldest.isEmpty()) {
            while (!stackNewest.isEmpty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }

    public T peek() {
        shiftStacks();
        return stackOldest.peek();
    }

    public T remove() {
        shiftStacks();
        return stackOldest.pop();
    }
}
