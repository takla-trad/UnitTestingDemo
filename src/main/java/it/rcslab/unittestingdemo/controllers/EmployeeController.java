package it.rcslab.unittestingdemo.controllers;

import it.rcslab.unittestingdemo.dto.EmployeeDTO;
import it.rcslab.unittestingdemo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public Page<EmployeeDTO> getAllEmployeesByPage(@RequestParam int page, @RequestParam int size) {
        return employeeService.getAllEmployees(page, size);
    }

    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/{id}/engaged")
    public boolean isEngaged(@PathVariable int id) {
        return employeeService.isEngaged(id);
    }

    @PostMapping("/")
    public ResponseEntity<Void> createEmployee(@RequestBody String name, HttpServletRequest httpServletRequest) {
        EmployeeDTO employeeDTO = employeeService.createEmployee(name);
        URI location = URI.create(httpServletRequest.getRequestURI() + "/" + employeeDTO.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}/engaged")
    public ResponseEntity<Void> setEngaged(@PathVariable int id, @RequestBody boolean engaged) {
        employeeService.setEngaged(id, engaged);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
