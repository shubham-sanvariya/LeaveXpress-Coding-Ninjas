package com.CodingNinjas.LeaveXpress.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CodingNinjas.LeaveXpress.dto.LeaveDto;
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

    public List<LeaveModel> getAllLeaves(){
        return leaveRepository.findAll();
    }

    public List<LeaveModel> getAllAcceptedLeaves(){
        return leaveRepository.findByAccepted(true);
    }

    public List<LeaveModel> getAllRejectedLeaves() {
        return leaveRepository.findByAccepted(false);
    }

    public boolean getLeaveStatusById(Long id){
        return getLeaveById(id).isAccepted();
    }

    public void updateLeaveById(Long id, LeaveDto leaveDto){
        LeaveModel leaveModel = getLeaveById(id);
        leaveModel.setType(leaveDto.getType());
        leaveModel.setStartDate(leaveDto.getStartDate());
        leaveModel.setEndDate(leaveDto.getEndDate());
        leaveModel.setDescription(leaveDto.getDescription());

        leaveRepository.save(leaveModel);
    }

    public void deleteLeaveById(Long id){
        leaveRepository.deleteById(id);
    }

    public void applyForLeave(LeaveDto leaveDto){
        LeaveModel leaveModel = new LeaveModel(leaveDto.getType(),leaveDto.getStartDate(),
        leaveDto.getEndDate(),leaveDto.getDescription());

        leaveRepository.save(leaveModel);
    }

    public void acceptLeaveById(Long id){
        LeaveModel leaveModel = getLeaveById(id);
        leaveModel.setAccepted(true);
        leaveRepository.save(leaveModel);
    }

    public void rejectLeaveById(Long id) {
        LeaveModel leaveModel = getLeaveById(id);
        leaveModel.setAccepted(false);
        leaveRepository.save(leaveModel);
    }
}
