package com.example.homework_2_5.Controller;

import com.example.homework_2_5.Service.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final  EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String hello(){
        return "Приветствуем";
    }

//    Чтение сотрудников
    @GetMapping(path = "/toString")
    public String toStringEmployee(){
        return employeeService.toStringEmployee();
    }

//    Найти сотрудника
//    http://localhost:8080/employee/find?firstName=David&lastName=Hkkf
    @GetMapping(path = "/find")
    public String findEmployee(@RequestParam(name = "firstName") String firstName,
                               @RequestParam(name = "lastName") String lastName){
        return employeeService.findEmployee(firstName, lastName);
    }

//    добавить сотрудника
//    http://localhost:8080/employee/add?firstName=David&lastName=Hkkf
//    http://localhost:8080/employee/add?firstName=Davna&lastName=Nok
//    http://localhost:8080/employee/add?firstName=Cet&lastName=Has
    @GetMapping(path = "/add")
    public String addNewEmployee(@RequestParam(name = "firstName") String firstName,
                                 @RequestParam(name = "lastName") String lastName){
        return employeeService.addNewEmployee(firstName, lastName);
    }

//    удалить сотрудника
//    http://localhost:8080/employee/remove?firstName=David&lastName=Hkkf
    @GetMapping(path = "/remove")
    public String deleteEmployee(@RequestParam(name = "firstName") String firstName,
                                 @RequestParam(name = "lastName") String lastName){
        return employeeService.deleteEmployee(firstName, lastName);
    }
}
