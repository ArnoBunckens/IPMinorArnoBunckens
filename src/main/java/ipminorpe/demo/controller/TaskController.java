package ipminorpe.demo.controller;

import ipminorpe.demo.dto.SubtaskDTO;
import ipminorpe.demo.dto.TaskDTO;
import ipminorpe.demo.domain.Task;
import ipminorpe.demo.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/")
public class TaskController {

    @Autowired
    private TaskListService taskList;

    @GetMapping("/")
    public String homepage(){
        return "fragments/header";
    }
    @GetMapping("/tasks")
    public String tasks(Model model) {
        model.addAttribute("tasks", taskList.getAll());
        return "tasks";
    }

    @GetMapping("/tasks/{id}")
    public String taskDetail(Model model, @PathVariable UUID id) {
        model.addAttribute("taakje", taskList.getTaskById(id));
        model.addAttribute("taakjes", taskList.getTaskById(id).getSubtasks());
        System.out.println(taskList.getTaskById(id).getSubtasks().size());
        return "taskDetail";
    }

    @GetMapping("/new")
    public String newTask(Model model) {

        return "addTask";

    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute TaskDTO task) {
        taskList.addTask(task);
        System.out.println(task.toString());
        return "redirect:/tasks";

    }

    @GetMapping("/edit/{id}")
    public String editTask(Model model, @PathVariable UUID id){
        model.addAttribute(taskList.getTaskDTOById(id));
        model.addAttribute("id", id);
        model.addAttribute("taak", taskList.getTaskById(id));
        return "editTask";
    }

    @PostMapping("/confEdit")
    public String confirmEdit(@ModelAttribute Task task,  @RequestParam UUID nummer, TaskDTO taskDTO){
        System.out.println(task.toString());
        task.setId(nummer);
        taskDTO.setId(nummer);
        taskList.editTaskByTaskDTO(taskDTO);
        return "redirect:/tasks/"+ task.getId() ;

    }

    @GetMapping("/tasks/{id}/sub/create")
    public String subTaskPage(Model model, @PathVariable UUID id){
        return "createsSub";
    }

    @PostMapping("/{taskid}/sub/create/task")
    public String addSubtask(Model model, @PathVariable UUID taskid, @ModelAttribute SubtaskDTO subtask){
        taskList.addSubtask(taskid, subtask);
        System.out.println(taskList.getTaskById(taskid).getSubtasks().size() + "  hobbit");
        return "redirect:/tasks/"+ taskid;
    }

}
