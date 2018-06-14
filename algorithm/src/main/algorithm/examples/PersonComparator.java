package algorithm.examples;

import java.util.Comparator;

public class PersonComparator implements Comparator<Person> {
    public int compare(Person p1, Person p2) {
        return p1.getAge().compareTo(p2.getAge());
    }
}