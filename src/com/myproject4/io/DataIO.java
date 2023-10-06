package com.myproject4.io;

import com.myproject4.model.Person;

import java.util.List;

public interface DataIO {
    void writeData(List<Person> data, String filename);
    List<Person> readData(String filename);
}
