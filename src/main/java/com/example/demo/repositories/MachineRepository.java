package com.example.demo.repositories;





import com.example.demo.entities.Employe;
import com.example.demo.entities.Machine;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MachineRepository extends CrudRepository<Machine,Long> {
    @Query("SELECT m FROM Machine m WHERE m.employe.id = :employeId")
    List<Machine> findByEmployeId(Long employeId);
}

