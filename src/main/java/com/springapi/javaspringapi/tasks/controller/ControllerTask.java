package com.springapi.javaspringapi.tasks.controller;

import com.springapi.javaspringapi.tasks.entity.Task;
import com.springapi.javaspringapi.tasks.service.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tasks")
public class ControllerTask {
    @Autowired
    private ServiceTask serviceTask;

    @GetMapping("/{id}")
    @ResponseBody
    public Task getTaskById(@PathVariable("id") int id){
        return serviceTask.getTask(id);
    }

    @GetMapping ("/allTasks")
    @ResponseBody
    public List getAllTasks(){
        return serviceTask.getAllTasks();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public Task updateTaskById(@PathVariable("id") int id, @RequestBody Task task){
        task.setId(id);
        return serviceTask.updateTask(task, id);
    }

    @PostMapping
    @ResponseBody
    public Task createTask( @RequestBody Task task){
        return serviceTask.createTask(task);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public String createTask( @PathVariable int id){
        return serviceTask.deleteTask(id);
    }
}
