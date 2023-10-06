package com.myproject6.model;

import java.util.*;

public class FamilyTree implements Iterable<Person> {
    private Person root;

    public FamilyTree(Person root) {
        this.root = root;
    }

    public List<Person> getChildren(String name) {
        return findPerson(root, name).getChildren();
    }

    private Person findPerson(Person root, String name) {
        if (root.getName().equals(name)) {
            return root;
        } else {
            for (Person child : root.getChildren()) {
                Person result = findPerson(child, name);
                if (result != null) {
                    return result;
                }
            }
            return null;
        }
    }

    @Override
    public Iterator<Person> iterator() {
        List<Person> people = new ArrayList<>();
        addPeople(root, people);
        return people.iterator();
    }

    private void addPeople(Person person, List<Person> people) {
        people.add(person);
        for (Person child : person.getChildren()) {
            addPeople(child, people);
        }
    }
}