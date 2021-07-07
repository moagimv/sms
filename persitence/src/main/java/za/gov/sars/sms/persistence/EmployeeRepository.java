/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.gov.sars.sms.domain.Employee;

/**
 *
 * @author S2026987
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    @Query("SELECT e FROM Employee e WHERE e.employeeId =:employeeId")
    public Employee findEmployeeByEmployeeId(@Param("employeeId") String employeeId);
}
