package com.myproject6.io;

import com.myproject6.model.Person;

import java.util.List;

public interface DataIO {
    void writeData(List<Person> data, String filename);
    List<Person> readData(String filename);
}
