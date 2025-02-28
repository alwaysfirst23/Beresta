package org.example;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Task {
    private String title; // Заголовок
    private String description; // Описание
    private int priority; // Приоритет: 0-низкий, 1-средний, 2-срочно, 3-максимально срочно
    private LocalDate deadline; // Дедлайн
    private String worker; // Исполнитель

    public Task(String title, String description, int priority, LocalDate deadline, String worker) throws IllegalArgumentException {
        if (title == null || title.trim().isEmpty() || description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Нельзя создать задачу без названия или описания");
        }
        if (priority < 0 || priority > 3) {
            throw new IllegalArgumentException("Приоритет должен быть от 0 до 3");
        }
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.worker = worker;
    }

    public Task(String title, String description, int priority, LocalDate deadline) {
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.deadline = deadline;
        this.worker = "Я";
    }

    /*
    Нужно внедрить проверку, чтобы нельзя было в результате редактирования получить
    задачу без обязательных полей
     */

    public void editTitle(String title) {
        this.title = title;
    }

    public void editDescription(String description) {
        this.description = description;
    }

    public void editPriority(int priority) throws IllegalArgumentException {
        if (priority < 0 || priority > 3) {
            throw new IllegalArgumentException("Приоритет должен быть от 0 до 3");
        }
        this.priority = priority;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getFormattedDeadline(String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        return deadline.format(formatter);
    }

    public long daysUntilDeadline() {
        LocalDate today = LocalDate.now(); // Получаем текущую дату
        return ChronoUnit.DAYS.between(today, deadline); // Вычисляем количество дней между сегодня и дедлайном
    }

    public void print() {
        System.out.printf("%-25s %s%n", "Заголовок", title);
        System.out.printf("%-25s %s%n", "Описание задачи", description);
        System.out.printf("%-25s %s (%s)%n", "Приоритет", priority, whichPriority(priority));
        System.out.printf("%-25s %s%n", "Дедлайн", deadline);
        long days_left = daysUntilDeadline();
        if (days_left >= 0){
            System.out.printf("%-25s %s%n", "Дней до дедлайна", days_left);
        } else {
            System.out.printf("%-25s %s%n", "Просрочено на (дней)", Math.abs(days_left));
        }
        System.out.printf("%-25s %s%n", "Исполнитель", worker);
    }


    private String whichPriority(int priority){
        switch (priority){
            case 0: return "Вообще не срочно";
            case 1: return "Не особо срочно";
            case 2: return "Срочно";
            case 3: return "Очень срочно!";
        }
        return "ERROR";
    }
}
