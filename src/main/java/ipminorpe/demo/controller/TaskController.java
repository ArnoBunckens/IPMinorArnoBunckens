package ipminorpe.demo.controller;

import ipminorpe.demo.domain.DB;
import ipminorpe.demo.domain.Task;
import ipminorpe.demo.domain.TaskList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/TaskList")
public class TaskController {
    @Autowired
    DB taskList;

    @GetMapping("/Tasks")
    public String tasks(Model model){
        model.addAttribute("tasks", taskList.getAll());
        return "tasks";
    }

   @GetMapping("/Tasks/{id}")
    public String taskDetail(Model model, @PathVariable int id) {
        model.addAttribute("taakje", taskList.findDescription(String.valueOf(id)));
        return "taskDetail";
    }
}
