package com.springapi.javaspringapi.tasks.service;

import com.springapi.javaspringapi.tasks.entity.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class ServiceTask {
    private final HashMap<Integer, Task> tasks = new HashMap<Integer, Task>();

    public Task createTask(Task task){
        int newId = tasks.size() + 1;
        task.setId(newId);
        tasks.put(newId, task);
        return task;
    }

    public Task getTask(int id){
        return tasks.get(id);
    }

    public List<Task> getAllTasks(){
        return new ArrayList<Task>(tasks.values());
    }

    public Task updateTask(Task task, int id){
        tasks.put(id, task);
        return task;
    }

    public String deleteTask(int id){
        tasks.remove(id);
        return "Task deleted";
    }

}
