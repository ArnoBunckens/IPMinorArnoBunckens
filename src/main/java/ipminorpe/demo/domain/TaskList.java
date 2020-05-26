package ipminorpe.demo.domain;


import java.util.List;

public interface TaskList {
    List<Task> getAll();

    Task findDescription(String id);
}


