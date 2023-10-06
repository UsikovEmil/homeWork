package com.myproject3.presenter;

import com.myproject3.model.FamilyTree;
import com.myproject3.model.Person;
import com.myproject3.view.View;
import com.myproject3.presenter.Presenter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConsolePresenter implements Presenter {
    private FamilyTree familyTree;
    private View view;

    public ConsolePresenter(FamilyTree familyTree, View view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void onViewPerson(String name) {
        List<Person> children = familyTree.getChildren(name);
        if (children != null) {
            view.showPeople(children);
        } else {
            view.showMessage("Человек с именем " + name + " не найден.");
        }
    }

    @Override
    public void onViewAllPeople() {
        List<Person> people = sortPeopleByName();
        view.showPeople(people);
    }

    private List<Person> sortPeopleByName() {
        List<Person> people = (List<Person>) familyTree;
        Collections.sort(people, Comparator.comparing(Person::getName));
        return people;
    }
}