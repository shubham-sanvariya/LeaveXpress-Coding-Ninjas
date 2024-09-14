package com.CodingNinjas.LeaveXpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.service.LeaveService;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {
    
    @Autowired
    private LeaveService leaveService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeaveModel getLeaveById(@PathVariable Long id){
        return leaveService.getLeaveById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<LeaveModel> getAllLeave(){
        return leaveService.getAllLeaves();
    }

    @GetMapping("/accepted")
    @ResponseStatus(HttpStatus.OK)
    public List<LeaveModel> getAllAcceptedLeaves(){
        return leaveService.getAllAcceptedLeaves();
    }
    
}
