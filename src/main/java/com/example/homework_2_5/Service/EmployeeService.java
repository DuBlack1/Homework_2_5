package com.example.homework_2_5.Service;

public interface EmployeeService {
    String toStringEmployee();

    //    Найти сотрудника
    String findEmployee(String firstName, String lastName);

    String addNewEmployee(String firstName, String lastName);

    String deleteEmployee(String firstName, String lastName);
}
