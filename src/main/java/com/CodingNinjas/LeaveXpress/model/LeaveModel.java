package com.CodingNinjas.LeaveXpress.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class LeaveModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String startDate;

    private String endDate;

    private String description;

    private boolean isAccepted;

    public LeaveModel(String type, String startDate, String endDate, String description) {
        this.type = type;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }
}
