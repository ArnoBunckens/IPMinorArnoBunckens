package ipminorpe.demo;


import ipminorpe.demo.domain.Task;
import ipminorpe.demo.dto.TaskDTO;
import ipminorpe.demo.service.TaskListService;
import ipminorpe.demo.service.TaskListServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class DemoTaskListServiceImpTest {
    @Autowired
    public TaskListService taskListService;

    TaskListService testTastService;
    TaskDTO dto = new TaskDTO();

    @BeforeTestClass
    public void setup() {
        dto.setNaam("Fantastisch");
        dto.setDateTime(LocalDateTime.of(2020,12,31,23,59));
        dto.setDescription("Niks werkt");
        testTastService.addTask(dto);
    }

    @Test
    public void testGetAll(){

    }
}

