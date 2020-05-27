package ipminorpe.demo.dto;

import ipminorpe.demo.domain.Subtask;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskDTO {
    private UUID id;
    private String naam;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;
    private String dueDate;
    private String description;
    private List<SubtaskDTO> subtasks;

    public TaskDTO() {
        subtasks = new ArrayList<>();
    }

    private boolean isValidDate(int day, int month, int year, int hour, int minute){
        return (day < 32 && day > 0 && month < 13 && month > 0 && hour >=0 && hour < 24 && minute >=0 && minute <61);
    }

    public TaskDTO(String naam, LocalDateTime dateTime, String description) {
        this.id = UUID.randomUUID();
        this.naam = naam;
        this.dateTime = dateTime;
        this.description = description;
        this.subtasks = new ArrayList<>();
    }

    public String getDescription() {
        return description;
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setDueDate(LocalDateTime dateTime) {
        this.dueDate = dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT));

    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void addSubtask(SubtaskDTO subtask){
        subtasks.add(subtask);
    }

    public void deleteSubtask(String subtask){
        SubtaskDTO subtask1 = null;
        for(SubtaskDTO s : subtasks){
            if(s.getTitel().equalsIgnoreCase(subtask)){
                subtask1 = s;

            }

        }
        subtasks.remove(subtask1);

    }
    public SubtaskDTO getSubtask(UUID id){
        for(SubtaskDTO s : subtasks){
            if(s.getId().equals(id)){
                return s;
            }
        }
        return null;
    }


    public List<SubtaskDTO> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<SubtaskDTO> subtasks){
        this.subtasks = subtasks;
    }

}



