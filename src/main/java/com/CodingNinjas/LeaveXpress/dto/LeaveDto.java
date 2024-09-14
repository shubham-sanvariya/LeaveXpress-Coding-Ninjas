package com.CodingNinjas.LeaveXpress.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LeaveDto {
    private String type;

    private String startDate;

    private String endDate;

    private String description;
}
