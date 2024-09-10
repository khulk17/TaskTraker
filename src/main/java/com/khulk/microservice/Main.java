package com.khulk.microservice;

import com.khulk.microservice.models.Status;
import com.khulk.microservice.models.TaskRepo;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        TaskRepo taskRepo = new TaskRepo();
        boolean Exit=false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Starting the App");
        System.out.println("Please enter your command line arguments:");
        while (!Exit){
            System.out.print("task-cli ");
            String command = scanner.nextLine();
            String[] strings= command.split(" ",2);
            switch (strings[0]){
                case "exit":
                    Exit=true;
                    break;
                case "add":
                    System.out.println(taskRepo.addTask(strings[1], Status.TODO));
                    break;
                case "update":
                    String[] strings2 = strings[1].split(" ",2);
                    System.out.println(taskRepo.UpdateTaskDescription(strings2[0],strings2[1]));
                    break;
                case "mark-in-progress":
                    System.out.println(taskRepo.UpdateTaskStatus(strings[1],"InProgress"));
                    break;
                case "mark-done":
                    System.out.println(taskRepo.UpdateTaskStatus(strings[1],"Done"));
                    break;
                case "list":
                    if (strings.length == 1){
                        System.out.println(taskRepo.GetAllTasks());
                    }else if (strings.length == 2){
                        System.out.println(taskRepo.getTasksBYStatus(strings[1]));
                    }
                    break;
                case "delete":
                    System.out.println(taskRepo.DeleteTask(strings[1]));
                    break;
                default:
                    System.out.println("Please enter a valid command");
            }
        }
    }
}