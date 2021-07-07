/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.Date;
import za.gov.sars.sms.domain.Assessment;
import za.gov.sars.sms.persistence.AssessmentRepository;

/**
 *
 * @author S2026987
 */
public class AssessmentHelper {
    
    public static void addAssessment(AssessmentRepository assessmentRepository){
        Assessment assessment1 = new Assessment();
        assessment1.setCreatedBy("test");
        assessment1.setCreatedDate(new Date());
        assessment1.setName("Test Assessment 1");
        assessment1.setDescription("A test assessment 1 for test cases with full mark of 100% and pass mark of 50%");
        assessment1.setFullMark(100.00D);
        assessment1.setPassMark(50.00D);
        assessment1.setDueDate(new Date());
        assessmentRepository.save(assessment1);
        
        Assessment assessment2 = new Assessment();
        assessment2.setCreatedBy("test");
        assessment2.setCreatedDate(new Date());
        assessment2.setName("Test Assessment 2");
        assessment2.setDescription("A test assessment 2 for test cases with full mark of 50 marks and pass mark of 20 marks");
        assessment2.setFullMark(50.00D);
        assessment2.setPassMark(20.00D);
        assessment2.setDueDate(new Date());
        assessmentRepository.save(assessment2);
    }
}
