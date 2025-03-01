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
        System.out.println("Выберите действие (введите число):  \n(1) Создать новую задачу " +
                "\n(2) Удалить задачу по индексу " +
                "\n(3) Изменить задачу по индексу " +
                "\n(4) Вывести все задачи\n");
        int choice = scanner.nextInt();
        scanner.close();

        switch (choice){
            case 1:
                task_list.createTask(dateFormatter);
                break;
            case 2:
                task_list.removeTask();
                break;
            case 3:
                break;
            case 4:
                task_list.printAllTasks();
                break;
        }

    }
}
