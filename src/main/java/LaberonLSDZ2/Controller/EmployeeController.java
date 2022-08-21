package LaberonLSDZ2.Controller;


import LaberonLSDZ2.Domain.Employee;
import LaberonLSDZ2.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {
    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/find")
    public Employee find(@RequestParam("name") String firstname,
                         @RequestParam("secondName") String secondname) {
        return employeeService.findPerson(firstname, secondname);
    }

    @GetMapping(path = "/add")
    public Employee add(@RequestParam("name") String firstname,
                        @RequestParam("secondName") String secondname) {
        return employeeService.addPerson(firstname, secondname);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam("name") String firstname,
                           @RequestParam("secondName") String secondname) {
        return employeeService.removePerson(firstname, secondname);
    }
}
