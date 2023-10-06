package com.myproject4;

import com.myproject4.model.FamilyTree;
import com.myproject4.model.Person;
import com.myproject4.view.ConsoleView;
import com.myproject4.presenter.ConsolePresenter;
import com.myproject4.io.FileDataIO;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        FileDataIO fileDataIO = new FileDataIO();

        Person grandParent = new Person("Бабушка/Дедушка", new Date());
        Person parent = new Person("Мама/Папа", new Date());
        grandParent.addChild(parent);
        parent.addChild(new Person("Ребенок 1", new Date()));
        parent.addChild(new Person("Ребенок 2", new Date()));

        FamilyTree familyTree = new FamilyTree(grandParent);

        ConsolePresenter presenter = new ConsolePresenter(familyTree, null);
        ConsoleView view = new ConsoleView(presenter);
        presenter.setView(view);

        view.start();
    }
}
