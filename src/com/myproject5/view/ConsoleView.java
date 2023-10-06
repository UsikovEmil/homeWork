package com.myproject5.view;

import com.myproject5.model.Node;
import com.myproject5.presenter.Presenter;

import java.util.List;
import java.util.Scanner;

public class ConsoleView<T> implements View<T> {
    private Presenter<T> presenter;
    private Scanner scanner = new Scanner(System.in);

    public ConsoleView(Presenter<T> presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("Введите данные или 'view' для просмотра всех узлов:");
            String input = scanner.nextLine();
            if (input.equals("view")) {
                presenter.onViewAllNodes();
            } else {
                presenter.onViewNode(input);
            }
        }
    }

    @Override
    public void showNodes(List<Node<T>> nodes) {
        for (Node<T> node : nodes) {
            System.out.println(node.getData().toString());
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}