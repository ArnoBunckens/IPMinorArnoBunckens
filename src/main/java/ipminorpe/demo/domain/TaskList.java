package ipminorpe.demo.domain;


import java.util.List;
import java.util.UUID;

public interface TaskList {
    List<Task> getAll();

    Task findDescription(UUID id);
}


