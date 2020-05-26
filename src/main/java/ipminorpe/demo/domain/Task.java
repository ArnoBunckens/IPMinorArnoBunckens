package ipminorpe.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.UUID;

public class Task {
    public UUID id;
    public String naam;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    public LocalDateTime dateTime;
    public String dueDate;
    public String description;


    public Task(String naam, LocalDateTime dateTime, String description) {
        this.id = UUID.randomUUID();
        this.naam = naam;
        this.dateTime = dateTime;
        setDueDate(dateTime);
        this.description = description;

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
}
