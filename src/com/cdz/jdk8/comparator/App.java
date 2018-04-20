package com.cdz.jdk8.comparator;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(new Person[]{new Person("Ted", "Neward", 41),
                new Person("Charlotte", "Neward", 41),
                new Person("Michael", "Neward", 19),
                new Person("Matthew", "Neward", 13)});
//        Collections.sort(persons, Comparator.comparing(Person::getFirstName).thenComparing(Person::getAge));
        Collections.sort(persons, Person.firstNameComparator);
        persons.forEach(person -> System.out.println(person.getAge()));
//        Calculate num = (from) -> (Integer.valueOf(from) + 100);
//        System.out.println(num.convert("9"));
//        Predicate<String> predicate = (s) -> s.length() > 0;
//        System.out.println(predicate.test("11"));
    }
}
