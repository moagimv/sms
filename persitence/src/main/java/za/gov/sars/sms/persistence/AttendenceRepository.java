/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import za.gov.sars.sms.domain.Attendence;

/**
 *
 * @author S2026987
 */
@Repository
public interface AttendenceRepository extends JpaRepository<Attendence, Long>{
    
    @Query("SELECT e FROM Attendence e WHERE e.grade.designation =:designation")
    public List<Attendence> findAttendenceByGradeDesignation(@Param("designation") String designation);
    
    @Query("SELECT e FROM Attendence e WHERE e.subject.name =:name")
    public List<Attendence> findAttendenceBySubjectName(@Param("name") String name);
    
    @Query("SELECT e FROM Attendence e WHERE e.educator.employeeId =:employeeId")
    public List<Attendence> findAttendenceByEducatorEmployeeId(@Param("employeeId") String employeeId);
    
}
