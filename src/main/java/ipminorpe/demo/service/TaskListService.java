package ipminorpe.demo.service;


import ipminorpe.demo.domain.Task;
import ipminorpe.demo.dto.SubtaskDTO;
import ipminorpe.demo.dto.TaskDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface TaskListService {
    List<TaskDTO> getAll();

    void addTask(TaskDTO task);

    public TaskDTO getTaskDTOById(UUID id);

    public Task getTaskById(UUID id);

    void addTask(String naam, LocalDateTime dateTime, String description);

    public void updateTask(Task task);

    public void addSubtask(UUID mainTaskId, SubtaskDTO subtaskDTO);

    public void editTaskByTaskDTO(TaskDTO taskDTO);


}


