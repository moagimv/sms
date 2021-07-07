/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import za.gov.sars.sms.domain.Employee;

/**
 *
 * @author S2026987
 */
public interface EmployeeServiceLocal {
    Employee save(Employee employee);

    Employee findById(Long id);

    Employee update(Employee employee);

    void deleteAll();

    Employee deleteById(Long id);

    Employee findEmployeeByEmployeeId(String employeeId);

    List<Employee> listAll();

    boolean isExist(Employee employee);

    long count();
}
