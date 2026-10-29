package Practical_13;

public class GenericStack<T> {

    private Object[] data;

    private int top = -1;

    public GenericStack(int size) {

        data = new Object[size];
    }

    public void push(T value) {

        if (top == data.length - 1) {

            System.out.println(
                    "Stack is full");

            return;
        }

        top++;

        data[top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {

        if (top == -1) {

            System.out.println(
                    "Stack is empty");

            return null;
        }

        T value =
                (T) data[top];

        data[top] = null;

        top--;

        return value;
    }

    @SuppressWarnings("unchecked")
    public T peek() {

        if (top == -1) {

            System.out.println(
                    "Stack is empty");

            return null;
        }

        return (T) data[top];
    }

    public boolean isEmpty() {

        return top == -1;
    }
}