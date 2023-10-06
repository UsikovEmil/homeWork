package com.myproject5.model;

import java.io.Serializable;
import java.util.*;

public class Person implements Serializable {
    private String name;
    private Date birthDate;
    private List<Person> children;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }
}