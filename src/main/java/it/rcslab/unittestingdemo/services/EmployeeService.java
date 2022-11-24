package it.rcslab.unittestingdemo.services;

import it.rcslab.unittestingdemo.dto.EmployeeDTO;
import org.springframework.data.domain.Page;

public interface EmployeeService {

    Page<EmployeeDTO> getAllEmployees(int page, int size);
    EmployeeDTO getEmployee(int id);

    /**
     * name should be unique
     * otherwise, an exception is thrown
     */
    EmployeeDTO createEmployee(String name);

    boolean isEngaged(int id);
    void setEngaged(int id, boolean engaged);

    /**
     * employee should not be engaged in order to be deleted
     * otherwise, an exception is thrown
     */
    void deleteEmployee(int id);
}
