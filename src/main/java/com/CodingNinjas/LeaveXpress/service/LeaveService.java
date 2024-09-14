package com.CodingNinjas.LeaveXpress.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingNinjas.LeaveXpress.exception.LeaveNotFoundException;
import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.repository.LeaveRepository;

@Service
public class LeaveService {
    
    @Autowired
    private LeaveRepository leaveRepository;

    public LeaveModel getLeaveById(Long id){
        return leaveRepository.findById(id)
        .orElseThrow(() -> new LeaveNotFoundException("leave not found by Id: " + id));
    }
}
