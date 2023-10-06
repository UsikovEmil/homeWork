package com.myproject7;

import java.util.*;

interface View {
    void start();
    void showEntries(List<Entry> entries);
    void showMessage(String message);
}

interface Presenter {
    void onAddEntry(String date, String note);
    void onViewEntries();
}

class ConsoleView implements View {
    private Presenter presenter;
    private Scanner scanner = new Scanner(System.in);

    ConsoleView(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        while (true) {
            System.out.println("Введите дату и заметку или 'view' для просмотра всех записей:");
            String input = scanner.nextLine();
            if (input.equals("view")) {
                presenter.onViewEntries();
            } else {
                String[] parts = input.split(" ", 2);
                if (parts.length < 2) {
                    showMessage("Неверный формат ввода. Попробуйте еще раз.");
                } else {
                    presenter.onAddEntry(parts[0], parts[1]);
                }
            }
        }
    }

    @Override
    public void showEntries(List<Entry> entries) {
        for (Entry entry : entries) {
            System.out.println(entry.getDate() + ": " + entry.getNote());
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}

class ConsolePresenter implements Presenter {
    private Model model;
    private View view;

    ConsolePresenter(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    @Override
    public void onAddEntry(String date, String note) {
        model.addEntry(new Entry(date, note));
        view.showMessage("Запись добавлена.");
    }

    @Override
    public void onViewEntries() {
        view.showEntries(model.getEntries());
    }

    public void setView(View view2) {
    }
}

interface Model {
    void addEntry(Entry entry);
    List<Entry> getEntries();
}

class Entry {
    private String date;
    private String note;

    Entry(String date, String note) {
        this.date = date;
        this.note = note;
    }

    String getDate() { return date; }
    String getNote() { return note; }
}

class NotebookModel implements Model {
    private List<Entry> entries = new ArrayList<>();

    @Override
    public void addEntry(Entry entry) { entries.add(entry); }

    @Override
    public List<Entry> getEntries() { return entries; }
}


public class main_07 {
        public static void main(String[] args) {
        Model model = new NotebookModel();
        Presenter presenter = new ConsolePresenter(model, null);
        View view = new ConsoleView(presenter);
        ((ConsolePresenter)presenter).setView(view);

        view.start();
    }
}
