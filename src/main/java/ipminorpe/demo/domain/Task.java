package ipminorpe.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Task {
    private UUID id;
    private String naam;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime dateTime;
    private String dueDate;
    private String description;
    private ArrayList<Subtask> subtasks;


    public Task(String naam, LocalDateTime dateTime, String description) {
        this.id = UUID.randomUUID();
        this.naam = naam;
        this.dateTime = dateTime;
        setDueDate(dateTime);
        this.description = description;
        this.subtasks = new ArrayList<>();

    }


    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getNaam() {
        return naam;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDueDate() {
        return dueDate;
    }


    public void setNaam(String naam) {
        this.naam = naam;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public UUID getId() {
        return id;
    }



    public void setDueDate(LocalDateTime dateTime) {
        this.dueDate = dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT));

    }

    public String toString(){
        return this.getId() + this.getNaam() + this.getDateTime() + this.getDescription();
    }

    public void addSubtask(Subtask subtask){
        subtasks.add(subtask);
    }

    public List<Subtask> getAllSubtasks() {
        return this.subtasks;
    }
}
