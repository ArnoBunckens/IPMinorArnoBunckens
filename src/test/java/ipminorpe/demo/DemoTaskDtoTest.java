package ipminorpe.demo;


import ipminorpe.demo.domain.Subtask;
import ipminorpe.demo.domain.Task;
import ipminorpe.demo.dto.SubtaskDTO;
import ipminorpe.demo.dto.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DemoTaskDtoTest {

    TaskDTO dto = new TaskDTO();

    @Test
    public void gettersTest(){
        dto.setNaam("hoe");
        dto.setDescription("Gaat het");
        dto.setDateTime(LocalDateTime.of(2222,12,12,12,12));
        assertEquals("hoe", dto.getNaam());
        assertEquals(LocalDateTime.of(2222,12,12,12,12), dto.getDateTime());
        assertEquals("Gaat het", dto.getDescription());
    }

    @Test
    public void addSubtaskWorks(){
        SubtaskDTO b = new SubtaskDTO();
        dto.addSubtask(b);
        assertNotNull(b);
        assertEquals(b, dto.getSubtask(b.getId()));
        assertEquals(1, dto.getSubtasks().size());
    }






}
