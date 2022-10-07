package com.example.homework_2_5.Service;

import com.example.homework_2_5.Class.Employee;
import com.example.homework_2_5.Exception.EmployeeNotFoundException;
import com.example.homework_2_5.Exception.EmployeeAlreadyAddedException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private List<Employee> EmployeeBook = new ArrayList<>();

//    Список сотрудников
    @Override
    public String toStringEmployee(){
        return EmployeeBook.toString();
    }

//    Найти сотрудника
    @Override
    public String findEmployee(String firstName, String lastName){
        Employee forFind = new Employee(firstName, lastName);
        for (int i = 0; i<EmployeeBook.size(); i++){
            if (EmployeeBook.get(i).equals(forFind)){
                return "Сотрудник найден";
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }

    // Добавить сотрудника
    @Override
    public String addNewEmployee(String firstName, String lastName){
        Employee forAdd = new Employee(firstName, lastName);
        for (int i = 0; i<EmployeeBook.size(); i++) {
            if (EmployeeBook.get(i).equals(forAdd)) {
                throw new EmployeeAlreadyAddedException("Сотрудник уже присутвует в списке");
            }
        }
        EmployeeBook.add(forAdd);
        return "Сотрудник добавлен";
    }

    //    Удалить сотрудника
    public String deleteEmployee(String firstName, String lastName){
        Employee forRemove = new Employee(firstName, lastName);
        if (EmployeeBook.remove(forRemove)) {
            return "Сотрудник удален";
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
}
