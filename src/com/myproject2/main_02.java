package com.myproject2;
import java.io.*;
import java.util.*;

interface DataIO {
    void writeData(List<Person> data, String filename);
    List<Person> readData(String filename);
}

class FileDataIO implements DataIO, Serializable {
    @Override
    public void writeData(List<Person> data, String filename) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(data);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    @Override
    public List<Person> readData(String filename) {
        List<Person> data = null;
        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            data = (List<Person>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
        }
        return data;
    }
}

class Person implements Serializable {
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

class FamilyTree implements Serializable {
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

public class main_02 {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        FileDataIO fileDataIO = new FileDataIO();
        
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

        // Запись данных в файл
        List<Person> dataToWrite = new ArrayList<>();
        dataToWrite.add(grandParent);
        
        fileDataIO.writeData(dataToWrite, "familyTreeData.txt");

        // Чтение данных из файла
        List<Person> readData = fileDataIO.readData("familyTreeData.txt");

        for (Person person : readData) {
            System.out.println("Имя: " + person.getName());
            
            for (Person child : person.getChildren()) {
                System.out.println("Ребенок: " + child.getName());
            }
            
            System.out.println("--------------------");
        }
        
    }
}