package Afleveringer.kompleksitet;

import java.util.Objects;

public class EntityWithComparable implements Comparable<EntityWithComparable> {

    int number;

    public EntityWithComparable(int number) {

        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(EntityWithComparable other) {

        return Integer.compare(this.number, other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof EntityWithComparable that)) return false;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return "EntityWithComparable{" +
                "number=" + number +
                '}';
    }
}



