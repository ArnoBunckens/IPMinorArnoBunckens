package ipminorpe.demo.controller;

import ipminorpe.demo.domain.DB;
import ipminorpe.demo.domain.Subtask;
import ipminorpe.demo.domain.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/taskList")
public class TaskController {
    @Autowired
    DB taskList;

    @GetMapping("/tasks")
    public String tasks(Model model) {
        model.addAttribute("tasks", taskList.getAll());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String taskDetail(Model model, @PathVariable UUID id) {
        model.addAttribute("taakje", taskList.findDescription(id));
        model.addAttribute("taakjes", taskList.findTaskById(id).getAllSubtasks());
        return "taskDetail";
    }

    @GetMapping("/new")
    public String newTask(Model model) {

        return "addTask";

    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        taskList.addTask(task);
        System.out.println(task.toString());
        return "redirect:/taskList/tasks";

    }

    @GetMapping("/edit/{id}")
    public String editTask(Model model, @PathVariable UUID id){
        model.addAttribute("id", id);
         model.addAttribute("taak", taskList.findTaskById(id));
         return "editTask";
    }

    @PostMapping("/confEdit")
    public String confirmEdit(@ModelAttribute Task task,  @RequestParam UUID nummer){
        System.out.println(task.toString());
        task.setId(nummer);
        taskList.updateTask(task);
        return "redirect:/taskList/tasks/"+ task.getId() ;

    }

    @GetMapping("/tasks/{id}/sub/create")
    public String subTaskPage(Model model, @PathVariable UUID id){
        return "createsSub";
    }

    @PostMapping("/{taskid}/sub/create/task")
    public String addSubtask(Model model, @PathVariable UUID taskid, @ModelAttribute Subtask subtask){
        taskList.findTaskById(taskid).addSubtask(subtask);
        return "redirect:/taskList/tasks/"+ taskid;
    }

}
