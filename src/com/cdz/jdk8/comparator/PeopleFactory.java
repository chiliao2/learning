package com.cdz.jdk8.comparator;

public interface PeopleFactory<p extends People> {
    People create(String firstName, String lastName);
}
