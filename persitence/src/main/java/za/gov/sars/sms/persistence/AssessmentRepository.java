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
import za.gov.sars.sms.domain.Assessment;

/**
 *
 * @author S2026987
 */
@Repository
public interface AssessmentRepository extends JpaRepository<Assessment, Long>{
    
    @Query("SELECT e FROM Assessment e WHERE e.student.studentNo =:studentNo")
    public List<Assessment> findAssessmentByStudentNo(@Param("studentNo") String studentNo);
    
    @Query("SELECT e FROM Assessment e WHERE e.educator.employeeId =:employeeId")
    public List<Assessment> findAssessmentByEmployeeId(@Param("employeeId") String employeeId);
    
}
