package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.EmployeeEntity;
 

 
@Repository
public interface EmployeeRepository 
        extends JpaRepository<EmployeeEntity, Long> {
 
}