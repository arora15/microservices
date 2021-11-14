package com.demo.ashish.userservice.service;

import com.demo.ashish.userservice.dto.Department;
import com.demo.ashish.userservice.dto.UserDepartmentDTO;
import com.demo.ashish.userservice.entity.User;
import com.demo.ashish.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;

    public UserDepartmentDTO getUserById(Long userId) {
        log.info("Inside the getUserById Method of the UserService");
        User user=userRepository.findById(userId).get();
        Department department=this.getDepartmentById(user.getDepartmentId());
        return new UserDepartmentDTO(user,department);
    }
    public User saveUser(User department){
        log.info("Inside the saveUser Method of the UserService");
        return userRepository.saveAndFlush(department);
    }

    public List<UserDepartmentDTO> getAllUsers() {
        log.info("Inside the getAllUsers Method of the UserService");
        List<User> users=this.userRepository.findAll();
        List<UserDepartmentDTO> userDepartmentDTOS=new ArrayList<>();
        UserDepartmentDTO userDepartmentDTO=null;
        Department department=null;
        for(User user : users)
        {
            userDepartmentDTO=new UserDepartmentDTO();
            userDepartmentDTO.setUser(user);
            department=this.getDepartmentById(user.getDepartmentId());
            userDepartmentDTO.setDepartment(department);
            userDepartmentDTOS.add(userDepartmentDTO);
        }
        return userDepartmentDTOS;
    }
    public Department getDepartmentById(Long departmentId)
    {
        log.info("Inside the getDepartmentById Method of the UserService");
        Department department=restTemplate.getForObject("http://API-GATEWAY/department/getdepartment/"+departmentId, Department.class);
        return department;
    }

}
