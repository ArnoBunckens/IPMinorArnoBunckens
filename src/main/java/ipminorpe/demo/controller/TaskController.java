package ipminorpe.demo.controller;

import ipminorpe.demo.domain.DB;
import ipminorpe.demo.domain.Task;
import ipminorpe.demo.domain.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.UUID;

@Controller
@RequestMapping("/TaskList")
public class TaskController {
    @Autowired
    DB taskList;

    @GetMapping("/Tasks")
    public String tasks(Model model) {
        model.addAttribute("tasks", taskList.getAll());
        return "tasks";
    }

    @GetMapping("/Tasks/{id}")
    public String taskDetail(Model model, @PathVariable UUID id) {
        model.addAttribute("taakje", taskList.findDescription(id));
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
        return "redirect:/TaskList/Tasks";

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
        return "redirect:/TaskList/Tasks/"+ task.getId() ;

    }
}
