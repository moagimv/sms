/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.Date;
import za.gov.sars.sms.domain.Grade;
import za.gov.sars.sms.persistence.GradeRepository;
import za.gov.sars.sms.persistence.SchoolRepository;

/**
 *
 * @author S2026987
 */
public class GradeHelper {
    
    public static void addGrade(GradeRepository gradeRepository, SchoolRepository schoolRepository){
        Grade grade1 = new Grade();
        grade1.setCreatedBy("test");
        grade1.setCreatedDate(new Date());
        grade1.setDesignation("Grade 12A");
        grade1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade1);
        
        Grade grade2 = new Grade();
        grade2.setCreatedBy("test");
        grade2.setCreatedDate(new Date());
        grade2.setDesignation("Grade 12B");
        grade2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade2);
        
        Grade grade3 = new Grade();
        grade3.setCreatedBy("test");
        grade3.setCreatedDate(new Date());
        grade3.setDesignation("Grade 11A");
        grade3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade3);
        
        Grade grade4 = new Grade();
        grade4.setCreatedBy("test");
        grade4.setCreatedDate(new Date());
        grade4.setDesignation("Grade 10A");
        grade4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade4);
        
        Grade grade5 = new Grade();
        grade5.setCreatedBy("test");
        grade5.setCreatedDate(new Date());
        grade5.setDesignation("Grade 10B");
        grade5.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        gradeRepository.save(grade5);
    }
}
