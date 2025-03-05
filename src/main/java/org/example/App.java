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
                "\n(4) Вывести все задачи" +
                "\n(5) Отметить задачу выполненной\n");

        String input = scanner.nextLine();
        int choice = Integer.parseInt(input);

        switch (choice) {
            case 1:
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
                try {
                    task_list.createTask(dateFormatter, title, description, priority, date, worker);
                } catch (IncorrectTask e){
                    System.out.println("Не удалось создать задачу \n");
                }
                break;
            case 2:
                task_list.removeTask();
                break;
            case 3:

                break;
            case 4:
                task_list.printAllTasks();
                break;
            case 5:
                System.out.println("Введите индекс задачи, которую нужно отметить выполненной:  ");
                input = scanner.nextLine();
                int index = Integer.parseInt(input);
                task_list.editDone(index);
                break;
            default:
                System.out.println("Некорректный выбор. Пожалуйста, попробуйте снова:\n");
        }

        scanner.close();

    }
}
