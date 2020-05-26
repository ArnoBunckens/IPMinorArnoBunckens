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
            if(x.getId().equals(id)){
                description =  x;
            }
        }
        return description;
    }

    @Override
    public Task findTaskById(UUID id) {

        for(Task x : tasks){
            if(x.getId().equals(id)){
                return x;
            }
            else return null;
        }
        return null;
    }

    public void addTask(Task task){
        tasks.add(task);
    }


    public void updateTask(Task task){
        for(Task x : tasks){
            if(x.getId().equals(task.getId())){
                x.setNaam(task.getNaam());
                x.setDueDate(task.getDateTime());
                x.setDescription(task.getDescription());

            }
        }
    }
}
