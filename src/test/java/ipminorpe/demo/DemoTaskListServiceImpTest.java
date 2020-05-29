package ipminorpe.demo;


import ipminorpe.demo.db.DbRepo;
import ipminorpe.demo.domain.Subtask;
import ipminorpe.demo.domain.Task;
import ipminorpe.demo.dto.SubtaskDTO;
import ipminorpe.demo.dto.TaskDTO;
import ipminorpe.demo.service.TaskListService;
import ipminorpe.demo.service.TaskListServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Transactional
@SpringBootTest
public class DemoTaskListServiceImpTest {
    @Autowired
    TaskListService taskListService;
    TaskDTO dto = new TaskDTO();

    @BeforeEach
    public void setup() {
        dto.setNaam("Plswork");
        dto.setDateTime(LocalDateTime.of(2020, 12, 12, 12, 12));
        dto.setDescription("description");
        dto.setId(UUID.randomUUID());
        System.out.println(dto.toString());
        System.out.println(taskListService.toString() + "Service");
        taskListService.addTask(dto);

    }


    @Test
    public void testGetAll(){
        assertEquals(1, taskListService.getAll().size());
    }

    @Test
    public void testAddTaskDTO(){
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setNaam("Naam");
        taskDTO.setDateTime(LocalDateTime.of(2020,12,12,12,12));

        taskDTO.setDescription("description");
        taskListService.addTask(taskDTO);
        assertEquals(2,taskListService.getAll().size());
    }

    @Test
    public void testAddTask(){
        taskListService.addTask("Taakje", LocalDateTime.of(2020,12,12,12,12), "Hoi");
        assertEquals(2,taskListService.getAll().size());
    }

    @Test
    public void testGetDTOByID(){
        TaskDTO t = taskListService.getAll().get(0);
        UUID x = t.getId();
        assertEquals(t.getNaam(),taskListService.getTaskDTOById(x).getNaam());
    }

    @Test
    public void testGetByID(){
        taskListService.addTask("titeltje",LocalDateTime.of(2020,12,12,12,12),"iets" );
        TaskDTO t = taskListService.getAll().get(taskListService.getAll().size()-1);
        UUID x = t.getId();
        assertEquals("titeltje", taskListService.getTaskById(x).getNaam());
    }

    @Test
    public void testAddSubTask(){
        taskListService.addTask("titel", LocalDateTime.of(2020,12,12,12,12), "iets");
        TaskDTO t = taskListService.getAll().get(taskListService.getAll().size()-1);

        SubtaskDTO dto = new SubtaskDTO();
        dto.setTitel("titel2");
        dto.setDescription("iets2");
        taskListService.addSubtask(t.getId(), dto);
        assertEquals(1, taskListService.getTaskDTOById(t.getId()).getSubtasks().size());
    }


}

