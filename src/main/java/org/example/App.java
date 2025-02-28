package org.example;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class App {
    public static void main(String[] args) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        TaskList task_list = new TaskList();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие (введите число):  \n(1) Создать новую задачу \n(2) Удалить задачу по индексу \n(3) Изменить задачу по индексу \n(4) Вывести все задачи\n");
        int choice = scanner.nextInt();
        scanner.close();

        switch (choice){
            case 1:
                createTask(task_list, dateFormatter);
                break;
                // Дописать кейсы
        }

    }


    // Убрать в класс TaskList
    public static void createTask(TaskList task_list, DateTimeFormatter dateFormatter) throws IncorrectTask{
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите заголовок задачи:  ");
        String title = scanner.nextLine();

        System.out.println("Введите описание задачи:  ");
        String description = scanner.nextLine();

        System.out.println("Введите приоритет (0-низкий, 1-средний, 2-срочно, 3-максимально срочно):  ");
        int priority = Integer.parseInt(scanner.nextLine());

        System.out.println("Введите дедлайн в формате (дд/мм/гггг):");
        LocalDate date = LocalDate.parse(scanner.nextLine(), dateFormatter);

        System.out.println("Введите исполнителя:  (Оставьте пустым, если исполнитель - вы)");
        String worker = scanner.nextLine();

        Task task;
        if (worker == null){
            task = new Task(title, description, priority, date);
        } else {
            task = new Task(title, description, priority, date, worker);
        }
        task_list.addTask(task);

        scanner.close();
    }
}
