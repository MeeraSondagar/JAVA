package Practical_6;

public interface Switchable {

    void on();

    void off();

    default void toggle() {
        System.out.println("Toggling device...");
        on();
        off();
    }
}