package com.example.demo.repositories;

import com.example.demo.entities.Employe;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeRepository extends CrudRepository<Employe, Long> {
    @Query("SELECT e.name, COUNT(m) FROM Employe e LEFT JOIN Machine m ON e.id = m.employe.id GROUP BY e.id")
    List<Object[]> getMachineCountByEmployee();
    @Query("SELECT e.name FROM Employe e")
    List<String> findAllEmployeeNames();


}
