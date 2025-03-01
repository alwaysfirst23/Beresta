package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskList {
    private LinkedList<Task> task_list;

    public TaskList() {
        task_list = new LinkedList<>();
    }

    // Метод для добавления задачи
    public void createTask(DateTimeFormatter dateFormatter) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите заголовок задачи:  ");
        String title = scanner.nextLine();

        System.out.println("Введите описание задачи:  ");
        String description = scanner.nextLine();

        System.out.println("Введите приоритет (0-низкий, 1-средний, 2-срочно, 3-максимально срочно):  ");
        int priority = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите дедлайн в формате (ДД/ММ/ГГГГ):");
        LocalDate date = LocalDate.parse(scanner.nextLine(), dateFormatter);

        System.out.println("Введите исполнителя:  (Оставьте пустым, если исполнитель - вы)");
        String worker = scanner.nextLine();
        scanner.close();

        Task task;
        if (worker == null){
            task = new Task(title, description, priority, date);
        } else {
            task = new Task(title, description, priority, date, worker);
        }
        task_list.add(task);
    }

    // Метод для удаления задачи по индексу
    public void removeTask() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите номер задачи, которую следует удалить, нумерация начинается с 1:  ");
        int index = scanner.nextInt();
        index++;
        scanner.close();
        if (index >= 0 && index < task_list.size()) {
            task_list.remove(index);
        } else {
            System.out.println("Задача с таким индексом не найдена.");
        }
    }

    // Метод для редактирования задачи по индексу
    public void editTask(int index, String title, String description, int priority, LocalDate deadline) {
        if (index >= 0 && index < task_list.size()) {
            Task task = task_list.get(index);
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
        for (Task task : task_list) {
            task.print();
            System.out.println("--------------------------------------------------");
        }
    }

    // Метод для получения количества задач
    public int getTaskCount() {
        return task_list.size();
    }
}
