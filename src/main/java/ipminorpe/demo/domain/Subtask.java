package ipminorpe.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Entity
public class Subtask {
    @Id
    @GeneratedValue
    private UUID id;
    private String titel, description;

    public Subtask(String titel, String description) {
        this.id = UUID.randomUUID();
        this.titel = titel;
        this.description = description;
    }

    public Subtask() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
