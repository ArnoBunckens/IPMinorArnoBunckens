package ipminorpe.demo;

import ipminorpe.demo.domain.Subtask;
import ipminorpe.demo.domain.Task;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DemoTaskTest {
    Task taskje = new Task("hoe", LocalDateTime.of(2222,12,12,12,12), "Gaat het");


    @Test
    public void testTask(){
        Task task = new Task("iets", LocalDateTime.of(2020,5,27,12,0), "description");

        UUID uuid = task.getId();

        assertNotNull(task);
        assertEquals("description", task.getDescription());
        assertEquals("iets", task.getNaam());
        assertEquals(uuid, task.getId());
        assertEquals(LocalDateTime.of(2020, 5, 27, 12,0), task.getDateTime());
    }
    @Test
    public void addSubtaskWorks(){
        Task a = new Task("iets", LocalDateTime.of(2020,5,27,12,0), "description");
        Subtask b = new Subtask("titel", "description");

        a.addSubtask(b);
        assertNotNull(a);
        assertNotNull(b);
        assertEquals(b, a.getSubtaskById(b));
        assertEquals(1, a.getSubtasks().size());
    }

    @Test
    public void setterTest(){
        taskje.setDescription("hoi");
        taskje.setNaam("titel");
        taskje.setDateTime(LocalDateTime.of(2020, 12,12,12,12));
        assertEquals("titel", taskje.getNaam());
        assertEquals("hoi",taskje.getDescription());
        assertEquals(LocalDateTime.of(2020, 12,12,12,12), taskje.getDateTime());
    }


}
