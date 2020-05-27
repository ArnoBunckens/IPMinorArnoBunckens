package ipminorpe.demo.service;

import ipminorpe.demo.db.DbRepo;
import ipminorpe.demo.domain.Subtask;
import ipminorpe.demo.domain.Task;
import ipminorpe.demo.dto.SubtaskDTO;
import ipminorpe.demo.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskListServiceImp implements TaskListService {

    private final DbRepo tasks;

    @Autowired
    public TaskListServiceImp(DbRepo repo) {
        this.tasks = repo;
    }


    @Override
    public List<TaskDTO> getAll() {
        return tasks.findAll().stream().map(h -> {
            TaskDTO dto = new TaskDTO();
            dto.setId(h.getId());
            dto.setNaam(h.getNaam());
            dto.setDescription(h.getDescription());
            dto.setDateTime(h.getDateTime());

            dto.setSubtasks(h.getSubtasks()
                    .stream().map(s -> {
                        SubtaskDTO subtaskDTO = new SubtaskDTO();
                        subtaskDTO.setId(s.getId());
                        subtaskDTO.setTitel(s.getTitel());
                        subtaskDTO.setDescription(s.getDescription());

                        return subtaskDTO;
                    }).collect(Collectors.toList())
            );
            return dto;
        }).collect(Collectors.toList());
    }


    @Override
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setNaam(taskDTO.getNaam());
        task.setDescription(taskDTO.getDescription());
        task.setDateTime(taskDTO.getDateTime());

        task.setSubtasks(taskDTO.getSubtasks()
                .stream().map(s -> {
                    Subtask subtask = new Subtask();
                    subtask.setId(s.getId());
                    subtask.setTitel(s.getTitel());
                    subtask.setDescription(s.getDescription());

                    return subtask;
                }).collect(Collectors.toList())
        );

        tasks.save(task);
    }

    @Override
    public TaskDTO getTaskDTOById(UUID id) {
        Task task = tasks.findById(id).orElse(null);
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setNaam(task.getNaam());
        dto.setDescription(task.getDescription());
        dto.setDateTime(task.getDateTime());

        dto.setSubtasks(task.getSubtasks()
                .stream().map(s -> {
                    SubtaskDTO subtaskDTO = new SubtaskDTO();
                    subtaskDTO.setId(s.getId());
                    subtaskDTO.setTitel(s.getTitel());
                    subtaskDTO.setDescription(s.getDescription());

                    return subtaskDTO;
                }).collect(Collectors.toList())
        );

        return dto;
    }

    @Override
    public Task getTaskById(UUID id) {
        return tasks.findById(id).orElse(null);
    }

    @Override
    public void addTask(String naam, LocalDateTime dateTime, String description) {
        Task task = new Task(naam, dateTime, description);
        tasks.save(task);
    }

    @Override
    public void updateTask(Task task) {
        tasks.deleteById(task.getId());
        tasks.save(task);
    }

    @Override
    public void addSubtask(UUID taskId, SubtaskDTO subtaskDTO) {
        Subtask subtask = new Subtask();
        subtask.setTitel(subtaskDTO.getTitel());
        subtask.setDescription(subtaskDTO.getDescription());
        subtask.setId(subtaskDTO.getId());

        Task task = getTaskById(taskId);
        task.addSubtask(subtask);

        tasks.save(task);
    }

    @Override
    public void editTaskByTaskDTO(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setNaam(taskDTO.getNaam());
        task.setDescription(taskDTO.getDescription());
        task.setDateTime(taskDTO.getDateTime());

        task.setSubtasks(taskDTO.getSubtasks()
                .stream().map(s -> {
                    Subtask subtask = new Subtask();
                    subtask.setId(s.getId());
                    subtask.setTitel(s.getTitel());
                    subtask.setDescription(s.getDescription());

                    return subtask;
                }).collect(Collectors.toList())
        );
        tasks.save(task);
    }

    public void addTask(Task task) {
        tasks.save(task);
    }

}

