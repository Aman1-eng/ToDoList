package todolist;

import java.util.ArrayList;
import java.util.Scanner;

class Task {
    String description;
    boolean completed;

    Task(String description) {
        this.description = description;
        this.completed = false;
    }

    String getStatus() {
        return completed ? "Completed" : "Pending";
    }
}

public class ToDoListApp {

    static ArrayList<Task> tasks = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n==============================");
            System.out.println("      TO-DO LIST APP");
            System.out.println("==============================");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Update Task Status");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addTask();
                    break;

                case 2:
                    viewTasks();
                    break;

                case 3:
                    updateTask();
                    break;

                case 4:
                    deleteTask();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void addTask() {

        System.out.print("Enter task description: ");
        String desc = sc.nextLine();

        tasks.add(new Task(desc));

        System.out.println("Task Added Successfully!");
    }

    static void viewTasks() {

        if (tasks.isEmpty()) {
            System.out.println("No Tasks Found.");
            return;
        }

        System.out.println("\n-------------------------------------------");
        System.out.printf("%-5s %-25s %-10s\n", "No.", "Task", "Status");
        System.out.println("-------------------------------------------");

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.printf("%-5d %-25s %-10s\n",
                    i + 1,
                    t.description,
                    t.getStatus());
        }
    }

    static void updateTask() {

        viewTasks();

        if (tasks.isEmpty())
            return;

        System.out.print("\nEnter task number: ");
        int num = sc.nextInt();

        if (num >= 1 && num <= tasks.size()) {

            System.out.println("1. Completed");
            System.out.println("2. Pending");
            System.out.print("Choose Status: ");

            int status = sc.nextInt();

            if (status == 1)
                tasks.get(num - 1).completed = true;
            else
                tasks.get(num - 1).completed = false;

            System.out.println("Task Updated Successfully!");
        } else {
            System.out.println("Invalid Task Number.");
        }
    }

    static void deleteTask() {

        viewTasks();

        if (tasks.isEmpty())
            return;

        System.out.print("\nEnter task number to delete: ");
        int num = sc.nextInt();

        if (num >= 1 && num <= tasks.size()) {
            tasks.remove(num - 1);
            System.out.println("Task Deleted Successfully!");
        } else {
            System.out.println("Invalid Task Number.");
        }
    }
}