package cz.educanet;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named
@SessionScoped
public class TaskRepository implements Serializable {
    private List<Task> activeTasks = new ArrayList<>();
    private List<Task> finishedTasks = new ArrayList<>();
    private String input = "";


    public void addInput() {
        Task newTask = new Task();
        newTask.setName(input);
        newTask.setFinished(false);
        activeTasks.add(newTask);
        setInput("");
    }

    public void finishTask(Task task) {
        task.setFinished(true);
        finishedTasks.add(task);
        activeTasks.remove(task);
    }

    public void deleteTask(Task task) {
        finishedTasks.remove(task);
    }


    public String getInput() {
        return input;
    }
    public void setInput(String input) {
        this.input = input;
    }

    public List<Task> getActiveTasks() {
        return activeTasks;
    }
    public void setActiveTasks(List<Task> activeTasks) {
        this.activeTasks = activeTasks;
    }

    public List<Task> getFinishedTasks() {
        return finishedTasks;
    }
    public void setFinishedTasks(List<Task> finishedTasks) {
        this.finishedTasks = finishedTasks;
    }
}
