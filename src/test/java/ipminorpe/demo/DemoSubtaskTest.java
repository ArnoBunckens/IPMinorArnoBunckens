package ipminorpe.demo;


import ipminorpe.demo.domain.Subtask;
import ipminorpe.demo.domain.Task;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DemoSubtaskTest {
        Subtask subtask = new Subtask("hoe", "Gaat het");

    @Test
    public void createSubtask(){
        Subtask task = new Subtask("iets", "description");
        UUID uuid = task.getId();
        assertNotNull(task);
        assertEquals("description", task.getDescription());
        assertEquals("iets", task.getTitel());
        assertEquals(uuid, task.getId());
    }

    @Test
    public void gettersTest(){
        assertEquals("hoe", subtask.getTitel());
        assertEquals("Gaat het", subtask.getDescription());
    }

    @Test
    public void setterTest(){
        subtask.setDescription("hoi");
        subtask.setTitel("titel");
        assertEquals("titel", subtask.getTitel());
        assertEquals("hoi",subtask.getDescription());
    }
}
