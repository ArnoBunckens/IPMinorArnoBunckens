package ipminorpe.demo.db;

import ipminorpe.demo.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface  DbRepo extends  JpaRepository<Task, UUID>{

}
