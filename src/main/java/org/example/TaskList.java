package org.example;

import java.time.LocalDate;
import java.util.LinkedList;

public class TaskList {
    private LinkedList<Task> tasks;

    public TaskList() {
        tasks = new LinkedList<>();
    }

    // Метод для добавления задачи
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Метод для удаления задачи по индексу
    public void removeTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        } else {
            System.out.println("Задача с таким индексом не найдена.");
        }
    }

    // Метод для редактирования задачи по индексу
    public void editTask(int index, String title, String description, int priority, LocalDate deadline) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.editTitle(title);
            task.editDescription(description);
            task.editPriority(priority);
            task.setDeadline(deadline);
        } else {
            System.out.println("Задача с таким индексом не найдена.");
        }
    }

    // Метод для вывода всех задач
    public void printAllTasks() {
        for (Task task : tasks) {
            task.print();
            System.out.println("--------------------------------------------------");
        }
    }

    // Метод для получения количества задач
    public int getTaskCount() {
        return tasks.size();
    }
}
