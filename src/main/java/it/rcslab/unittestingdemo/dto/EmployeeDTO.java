package it.rcslab.unittestingdemo.dto;

import it.rcslab.unittestingdemo.entities.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeDTO {

    private Integer id;
    private String name;
    private boolean engaged;

    public static EmployeeDTO fromEntity(Employee e) {
        return new EmployeeDTO(e.getId(), e.getName(), e.isEngaged());
    }
}
