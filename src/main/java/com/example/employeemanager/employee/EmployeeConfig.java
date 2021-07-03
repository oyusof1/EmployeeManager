package com.example.employeemanager.employee;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository) {
        return args -> {
            Employee osman = new Employee(
                    "Osman",
                    "Osman@gmail.com",
                    "Software Developer"
            );

            Employee yusof = new Employee(
                    "Yusof",
                    "Yusof@gmail.com",
                    "Finance"
            );

            repository.saveAll(List.of(osman,yusof));
        };
    }
}
