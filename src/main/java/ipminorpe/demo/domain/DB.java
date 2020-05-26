package ipminorpe.demo.domain;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DB implements TaskList {
    private List<Task> tasks;

    public DB(){
        this.tasks = new ArrayList<>();
        tasks.add(new Task( "Voetballen", LocalDateTime.of(2020,2,27,21,30), "Leuke avond weer"));
    }

    @Override
    public List<Task> getAll() {
        return this.tasks;
    }

    @Override
    public Task findDescription(UUID id) {
        Task description = null;
        for(Task x : tasks){
            if(x.id.equals(id)){
                description =  x;
            }
        }
        return description;
    }

    public void addTask(Task task){
        tasks.add(task);
    }


}
