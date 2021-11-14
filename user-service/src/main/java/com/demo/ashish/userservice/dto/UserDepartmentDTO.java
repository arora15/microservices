package com.demo.ashish.userservice.dto;

import com.demo.ashish.userservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDepartmentDTO {
    private User user;
    private Department department;
}
