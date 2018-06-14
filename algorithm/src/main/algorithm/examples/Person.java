package algorithm.examples;

import java.util.Collections;
import java.util.LinkedList;

public class Person implements Comparable<Person> {
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int compareTo(Person otherPerson) {
        if (this.age < otherPerson.getAge()) {
            return 1;
        } else if (this.age == otherPerson.getAge()) {
            return 0;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        LinkedList<Person> personList = new LinkedList<Person>();
        Person person1 = new Person();
        person1.setAge(15);
        Person person2 = new Person();
        person2.setAge(20);
        personList.add(person1);
        personList.add(person2);
        Collections.sort(personList, new PersonComparator());
    }
}
