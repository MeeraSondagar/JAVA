package Practical_6;

@FunctionalInterface
public interface SwitchRule {

    boolean maySwitchOn(Switchable device, int hour);
}