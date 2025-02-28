package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        LocalDate date1 = LocalDate.parse("21/02/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate date2 = LocalDate.parse("23/02/2025", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        TaskList task_list = new TaskList();

        Task task1 = new Task("Задача 1", "Написать текст презентации",
                2, date1, "Света");

        task_list.addTask(task1);

        Task task2 = new Task("Задача 2", "Сделать презентацию",
                1, date2, "Катя");

        task_list.addTask(task2);

        task_list.printAllTasks();

        task_list.editTask(0, "Задача 1 (ред.)", "Дописать текст презентации",
                2, date1);

        task_list.printAllTasks();
    }
}
