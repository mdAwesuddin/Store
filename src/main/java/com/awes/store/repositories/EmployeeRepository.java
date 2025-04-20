package com.awes.store.repositories;

import com.awes.store.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
} // all the operations like getall, delete, findbyid is already done by JpaRepository you just need to pass entity and id type
