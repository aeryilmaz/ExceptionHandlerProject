package com.aeryilmaz.ExceptionHandlerProject.controllers;

import com.aeryilmaz.ExceptionHandlerProject.entity.Employe;
import com.aeryilmaz.ExceptionHandlerProject.exceptions.RecordNotFoundException;
import com.aeryilmaz.ExceptionHandlerProject.repo.IEmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class EmployeeRESTController {

    @Autowired
    private IEmployeRepository employeRepository;


    @PostMapping(value = "/employees")
    public ResponseEntity<Employe> addEmployee (@RequestBody @Valid Employe employee)
    {
        return ResponseEntity.ok(employeRepository.save(employee));
    }

    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employe> getEmployeeById (@PathVariable("id") Long id)
    {
        Optional<Employe> employee = employeRepository.findById(id);

        if(employee == null) {
            throw new RecordNotFoundException("Invalid employee id : " + id);
        }
        return new ResponseEntity(employee.get(), HttpStatus.OK);
    }


}
