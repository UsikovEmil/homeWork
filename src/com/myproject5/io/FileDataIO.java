package com.myproject5.io;

import com.myproject5.model.Person;

import java.io.*;
import java.util.List;

public class FileDataIO implements DataIO, Serializable {
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
