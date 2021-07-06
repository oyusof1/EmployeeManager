package com.example.employeemanager.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @CrossOrigin(origins="http://localhost:4200/")
    @GetMapping
    public List<Employee> getEmployee() {
        return employeeService.getEmployee();
    }

    @GetMapping(path="{employeeId}")
    public Optional<Employee> getSingleEmployee(@PathVariable Long employeeId) {
        return employeeService.getSingleEmployee(employeeId);
    }

    @PostMapping
    public void registerNewEmployee(@RequestBody Employee employee) {
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path="{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Long employeeId) {
        employeeService.deleteEmployee(employeeId);
    }

    @PutMapping(path = "{employeeId}")
    public void updateEmployee(@PathVariable("employeeId") Long employeeId,
                              @RequestParam(required = false) String name,
                              @RequestParam(required = false) String email) {
       employeeService.updateEmployee(employeeId, name, email);
    }
}
