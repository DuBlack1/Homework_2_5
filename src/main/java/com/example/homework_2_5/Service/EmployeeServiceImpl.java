package com.example.homework_2_5.Service;

import com.example.homework_2_5.Class.Employee;
import com.example.homework_2_5.Exception.EmployeeNotFoundException;
import com.example.homework_2_5.Exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private Map<String, Employee> EmployeeBook;

    public EmployeeServiceImpl() {
        this.EmployeeBook = new HashMap<>();
    }

    //    Список сотрудников
    @Override
    public String toStringEmployee(){
        return EmployeeBook.toString();
    }

//    Найти сотрудника
    @Override
    public String findEmployee(String firstName, String lastName){
        Employee forFind = new Employee(firstName, lastName);
        if (EmployeeBook.containsKey(forFind.getFullName())){
            return "Сотрудник найден";
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    // Добавить сотрудника
    @Override
    public String addNewEmployee(String firstName, String lastName){
        Employee forAdd = new Employee(firstName, lastName);
        if (EmployeeBook.containsKey(forAdd.getFullName())) {
            throw new EmployeeAlreadyAddedException("Сотрудник уже присутвует в списке");
        }
        EmployeeBook.put(forAdd.getFullName(), forAdd);
        return "Сотрудник добавлен";
    }

    //    Удалить сотрудника
    public String deleteEmployee(String firstName, String lastName){
        Employee forRemove = new Employee(firstName, lastName);
        if (EmployeeBook.containsKey(forRemove.getFullName())) {
            EmployeeBook.remove(forRemove.getFullName());
            return "Сотрудник удален";
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
}
