package com.CodingNinjas.LeaveXpress.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CodingNinjas.LeaveXpress.dto.LeaveDto;
import com.CodingNinjas.LeaveXpress.model.LeaveModel;
import com.CodingNinjas.LeaveXpress.service.LeaveService;

@RestController
@RequestMapping("/api/leave")
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public LeaveModel getLeaveById(@PathVariable Long id) {
        return leaveService.getLeaveById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<LeaveModel> getAllLeave() {
        return leaveService.getAllLeaves();
    }

    @GetMapping("/accepted")
    @ResponseStatus(HttpStatus.OK)
    public List<LeaveModel> getAllAcceptedLeaves() {
        return leaveService.getAllAcceptedLeaves();
    }

    @GetMapping("/rejected")
    @ResponseStatus(HttpStatus.OK)
    public List<LeaveModel> getAllRejectedLeaves() {
        return leaveService.getAllRejectedLeaves();
    }

    @GetMapping("/status/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean getLeaveStatusById(Long id) {
        return leaveService.getLeaveStatusById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateLeaveById(@PathVariable Long id, @RequestBody LeaveDto leaveDto){
        leaveService.updateLeaveById(id,leaveDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteLeaveById(@PathVariable Long id){
        leaveService.deleteLeaveById(id);
    }

    @PostMapping("/apply")
    @ResponseStatus(HttpStatus.OK)
    public void applyForLeave(@RequestBody LeaveDto leaveDto){
        leaveService.applyForLeave(leaveDto);
    }

    @PostMapping("/accept/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void acceptLeaveById(@PathVariable Long id){
        leaveService.acceptLeaveById(id);
    }
}
