package Practical_10;

import java.util.LinkedList;
import java.util.Queue;

public class SharedBuffer {

    private Queue<Integer> buffer =
            new LinkedList<>();

    private int capacity;

    public SharedBuffer(int capacity) {

        this.capacity = capacity;
    }

    public synchronized void produce(int value)
            throws InterruptedException {

        while (buffer.size() == capacity) {

            wait();
        }

        buffer.add(value);

        System.out.println(
                "Produced: " + value);

        notify();
    }

    public synchronized int consume()
            throws InterruptedException {

        while (buffer.isEmpty()) {

            wait();
        }

        int value = buffer.remove();

        System.out.println(
                "Consumed: " + value);

        notify();

        return value;
    }
}