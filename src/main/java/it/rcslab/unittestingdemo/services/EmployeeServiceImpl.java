package it.rcslab.unittestingdemo.services;

import it.rcslab.unittestingdemo.dto.EmployeeDTO;
import it.rcslab.unittestingdemo.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Page<EmployeeDTO> getAllEmployees(int page, int size) {
        return null;
    }

    @Override
    public EmployeeDTO getEmployee(int id) {
        return null;
    }

    @Override
    public EmployeeDTO createEmployee(String name) {
        return null;
    }

    @Override
    public boolean isEngaged(int id) {
        return false;
    }

    @Override
    public void setEngaged(int id, boolean engaged) {

    }

    @Override
    public void deleteEmployee(int id) {

    }
}
