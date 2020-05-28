package ipminorpe.demo;


import ipminorpe.demo.db.DbRepo;
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
    TaskListService testTastService;
    TaskDTO dto = new TaskDTO();

    @BeforeTestClass
    public void setup() {
        dto.setNaam("Plswork");
        dto.setDateTime(LocalDateTime.of(2020, 12, 12, 12, 12));
        dto.setDescription("Test description");
        testTastService.addTask(dto);

    }

    noice
}
