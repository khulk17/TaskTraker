package com.khulk.microservice.models;

import com.khulk.microservice.JSONwiter.JSON;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class TaskRepo {
    private  static HashMap<Integer,Task> tasks;
    private static JSON filewriter;

    static {
        try {
            filewriter = new JSON("Task Traker");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public TaskRepo() {
        tasks = new HashMap<>();
    }

    public String addTask(String Description,Status status) throws IOException {
        StringBuilder builder = new StringBuilder(Description);
        builder.deleteCharAt(0);
        builder.deleteCharAt(builder.length()-1);
        Task task = new Task(builder.toString(), status);
        tasks.put(task.getId(),task);
        if (filewriter.WriteToFile(tasks))
            return    "Task added successfully (ID: "+ task.getId() +")";
        else {
            return  "Task was not added successfully (ID: "+ task.getId() +")";
        }
    }

    public String UpdateTaskDescription(String id, String Description) throws IOException {
        StringBuilder builder = new StringBuilder(Description);
        builder.deleteCharAt(0);
        builder.deleteCharAt(builder.length()-1);
        int iid = Integer.parseInt(id);
        Task task = tasks.get(iid);
        task.setDescription(builder.toString());
        tasks.put(iid,task);
        if (filewriter.WriteToFile(tasks)){
            return "Task updated successfully (ID: "+ task.getId() +")";
        }else {
            return "Task was not updated successfully (ID: "+ task.getId() +")";
        }
    }
    public String UpdateTaskStatus(String id, String Status) throws IOException {
        int iid = Integer.parseInt(id);
        Task task = tasks.get(iid);
        task.setStatus(com.khulk.microservice.models.Status.valueOf(Status));
        if (filewriter.WriteToFile(tasks)){
            return "Task updated successfully (ID: "+ task.getId() +")";
        }else {
            return "Task was not updated successfully (ID: "+ task.getId() +")";
        }
    }

    public String DeleteTask(String id) throws IOException {
        int iid = Integer.parseInt(id);
        tasks.remove(iid);
        filewriter.WriteToFile(tasks);
        return "Task deleted successfully (ID: "+ id +")";
    }

    public String GetAllTasks() throws IOException {
        return filewriter.GetFileContent();
    }

    public String getTasksBYStatus(String status) throws IOException {
        Status s = com.khulk.microservice.models.Status.valueOf(status);
        List<Task> tasks1= tasks.values().stream().filter(task -> task.getStatus()==s).toList();
        return filewriter.convertToJSON(tasks1);
    }
}
