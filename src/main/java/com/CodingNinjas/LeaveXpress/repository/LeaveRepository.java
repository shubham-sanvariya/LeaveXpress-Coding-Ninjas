package com.CodingNinjas.LeaveXpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CodingNinjas.LeaveXpress.model.LeaveModel;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveModel,Long>{
    
}
