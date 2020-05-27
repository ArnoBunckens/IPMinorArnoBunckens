package ipminorpe.demo;


import ipminorpe.demo.dto.SubtaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class DemoSubtaskDtoTest {

    SubtaskDTO dto = new SubtaskDTO();

    @Test
    public void settersTest(){
        dto.setTitel("titel");
        dto.setDescription("description");
        assertEquals("titel", dto.getTitel());
        assertEquals("description", dto.getDescription());
    }

}
