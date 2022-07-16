package pro.sky.HW26.EmployeeService;

import org.springframework.stereotype.Service;
import pro.sky.HW26.Employee;
import pro.sky.HW26.exeption.EmployeeAlreadyAddedExeption;
import pro.sky.HW26.exeption.EmployeeNotFoundExeption;
import pro.sky.HW26.exeption.EmployeeStorageFullExeption;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    private static final int LIMIT = 10;
    private final List<Employee> employees = new ArrayList<>();

    public Employee addEmployee(String name) {
        Employee employee = new Employee(name);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedExeption();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageFullExeption();
    }

    public Employee findEmployee(String name) {
        Employee employee = new Employee(name);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundExeption();
        }
        return employee;
    }

    public Employee removeEmployee(String name) {
        Employee employee = new Employee(name);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundExeption();
        }
        employees.remove(employee);
        return employee;
    }

    public List<Employee> getAll() {
        return new ArrayList<>(employees);
    }
}

