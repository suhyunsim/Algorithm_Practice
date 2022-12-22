package main.java.com.poogle.cracking.Ch3StackQueue.Q4;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        MyQueue<Integer> myQueue = new MyQueue<>();
        Queue<Integer> testQueue = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            int choice = ThreadLocalRandom.current().nextInt(1, 11);
            if (choice <= 5) {
                int element = ThreadLocalRandom.current().nextInt(1, 11);
                testQueue.add(element);
                myQueue.add(element);
                System.out.println("Enqueued: " + element);
            } else if (testQueue.size() > 0) {
                int top1 = testQueue.remove();
                int top2 = myQueue.remove();
                if (top1 != top2) {
                    System.out.println("Fail - Different Tops: " + top1 + ", " + top2);
                }
                System.out.println("Dequeued: " + top1);
            }

            if (testQueue.size() == myQueue.size()) {
                if (testQueue.size() > 0 && testQueue.peek() != myQueue.peek()) {
                    System.out.println("Fail - Different Tops: " + testQueue.peek() + ", " + myQueue.peek());
                }
            } else {
                System.out.println("Fail - Different Sizes");
            }
        }
    }
}
