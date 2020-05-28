package ipminorpe.demo;


import ipminorpe.demo.domain.Task;
import ipminorpe.demo.dto.TaskDTO;
import ipminorpe.demo.service.TaskListService;
import ipminorpe.demo.service.TaskListServiceImp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class DemoTaskListServiceImpTest {
    @Autowired
    public TaskListService taskListService;

    

}
