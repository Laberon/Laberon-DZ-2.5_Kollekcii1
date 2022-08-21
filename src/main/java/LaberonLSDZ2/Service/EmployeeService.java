package LaberonLSDZ2.Service;

import LaberonLSDZ2.Domain.Employee;
import LaberonLSDZ2.Exception.EmployeeAlreadyAddedException;
import LaberonLSDZ2.Exception.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    List<Employee> persons=new ArrayList<>();


    public Employee addPerson(String firstName, String lastName) throws EmployeeAlreadyAddedException{
        Employee person = new Employee(firstName, lastName);
        if (persons.contains(person)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник есть в базе");
        } else {
            persons.add(person);
            return person;
        }
    }

    public Employee removePerson(String firstName, String lastName) throws EmployeeNotFoundException{
        Employee person = new Employee(firstName, lastName);
        if (persons.contains(person)) {
            persons.remove(person);
            return person;
    } else {
        throw new EmployeeNotFoundException("Сотрудник не найден");
        }
    }
    public Employee findPerson(String firstName, String lastName) throws EmployeeNotFoundException{
        Employee person = new Employee(firstName, lastName);
        if (persons.contains(person)) {
            return person;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
}

