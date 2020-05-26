package ipminorpe.demo.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class Task {
    public String id;
    public String naam;
    public LocalDateTime dateTime;
    public String dueDate;
    public String description;


    public Task(String id, String naam, LocalDateTime dateTime, String description) {
        this.id = id;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setDueDate(LocalDateTime dateTime) {
        this.dueDate = dateTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT, FormatStyle.SHORT));

    }
}
