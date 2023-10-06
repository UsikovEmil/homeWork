package com.myproject1;
import java.util.*;

class Person {
    private String name;
    private List<Person> children;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }
}

class FamilyTree {
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
}

public class main_01 {
    public static void main(String[] args) {
        Person grandParent = new Person("Бабушка/Дедушка");
        Person parent = new Person("Мама/Папа");
        grandParent.addChild(parent);
        parent.addChild(new Person("Ребенок 1"));
        parent.addChild(new Person("Ребенок 2"));

        FamilyTree familyTree = new FamilyTree(grandParent);

        System.out.println("Дети Мама/Папа:");
        for (Person child : familyTree.getChildren("Мама/Папа")) {
            System.out.println(child.getName());
        }
    }
}