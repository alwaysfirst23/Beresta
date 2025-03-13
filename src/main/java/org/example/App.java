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
        int choice = 1;

        while(choice != 0) {
            System.out.println("Выберите действие (введите число):  " +
                    "\n(0) Выход " +
                    "\n(1) Создать новую задачу " +
                    "\n(2) Удалить задачу по индексу " +
                    "\n(3) Изменить задачу по индексу " +
                    "\n(4) Вывести все задачи" +
                    "\n(5) Отметить задачу выполненной\n");

            String input = scanner.nextLine();
            choice = Integer.parseInt(input);

            switch (choice) {
                case 1: // Создание новой задачи
                    System.out.println("Введите заголовок задачи:  ");
                    String title = scanner.nextLine();

                    System.out.println("Введите описание задачи:  ");
                    String description = scanner.nextLine();

                    System.out.println("Введите приоритет (1-низкий, 2-средний, 3-срочно, 4-максимально срочно):  ");
                    int priority = Integer.parseInt(scanner.nextLine());

                    System.out.println("Введите дедлайн в формате (ДД/ММ/ГГГГ):");
                    LocalDate date = LocalDate.parse(scanner.nextLine(), dateFormatter);

                    System.out.println("Введите исполнителя:  (Оставьте пустым, если исполнитель - вы)");
                    String worker = scanner.nextLine();
                    try {
                        task_list.createTask(dateFormatter, title, description, priority, date, worker);
                    } catch (IncorrectTask e) {
                        System.out.println("Не удалось создать задачу \n");
                    }
                    break;
                case 2: // Удаление задачи по индексу
                    System.out.println("Введите номер задачи, которую хотите удалить:  ");
                    int delete_index = Integer.parseInt(scanner.nextLine());
                    task_list.removeTask(delete_index);
                    break;
                case 3:
                    System.out.println("Введите номер задачи, которую хотите редактировать:  ");
                    int edit_index = Integer.parseInt(scanner.nextLine());

                    System.out.println("Введите заголовок задачи:  ");
                    String edited_title = scanner.nextLine();

                    System.out.println("Введите описание задачи:  ");
                    String edited_description = scanner.nextLine();

                    System.out.println("Введите приоритет (1-низкий, 2-средний, 3-срочно, 4-максимально срочно):  ");
                    int edited_priority = Integer.parseInt(scanner.nextLine());

                    System.out.println("Введите дедлайн в формате (ДД/ММ/ГГГГ):");
                    LocalDate edited_date = LocalDate.parse(scanner.nextLine(), dateFormatter);

                    System.out.println("Введите исполнителя:  (Оставьте пустым, если исполнитель - вы)");
                    String edited_worker = scanner.nextLine();

                    try {
                        task_list.editTask(edit_index, edited_title, edited_description, edited_priority, edited_date, edited_worker);
                    } catch (IncorrectTask e) {
                        System.out.println("Не удалось создать задачу \n");
                    }
                    break;
                case 4:
                    task_list.printAllTasks();
                    break;
                case 5:
                    System.out.println("Введите индекс задачи, которую нужно отметить выполненной:  ");
                    int number = Integer.parseInt(scanner.nextLine());
                    task_list.editDone(number);
                    break;
                default:
                    System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова:\n");
            }
        }
        scanner.close();
    }
}
