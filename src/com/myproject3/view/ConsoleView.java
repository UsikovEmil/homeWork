package com.myproject3.view;

import com.myproject3.model.Person;
import com.myproject3.presenter.Presenter;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View {
    private Presenter presenter;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleView(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("Введите имя человека или 'view' для просмотра всех людей:");
            String input = scanner.nextLine();
            if (input.equals("view")) {
                presenter.onViewAllPeople();
            } else {
                presenter.onViewPerson(input);
            }
        }
    }

    @Override
    public void showPeople(List<Person> people) {
        for (Person person : people) {
            System.out.println(person.getName() + ": " + person.getBirthDate());
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
