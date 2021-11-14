package com.demo.ashish.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Department {
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentHead;
}
