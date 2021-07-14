/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.Date;
import za.gov.sars.sms.domain.Subject;
import za.gov.sars.sms.persistence.SchoolRepository;
import za.gov.sars.sms.persistence.SubjectRepository;

/**
 *
 * @author S2026987
 */
public class SubjectHelper {
    
    public static void addSubject(SubjectRepository subjectRepository, SchoolRepository schoolRepository){
        Subject subject1 = new Subject();
        subject1.setCreatedBy("test");
        subject1.setCreatedDate(new Date());
        subject1.setName("Mathematic");
        subject1.setCode("MATH12G");
        subject1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject1);
        
        Subject subject2 = new Subject();
        subject2.setCreatedBy("test");
        subject2.setCreatedDate(new Date());
        subject2.setName("Mathematic");
        subject2.setCode("MATH11G");
        subject2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject2);
        
        Subject subject3 = new Subject();
        subject3.setCreatedBy("test");
        subject3.setCreatedDate(new Date());
        subject3.setName("Mathematic");
        subject3.setCode("MATH10G");
        subject3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject3);
        
        Subject subject4 = new Subject();
        subject4.setCreatedBy("test");
        subject4.setCreatedDate(new Date());
        subject4.setName("Physical Science");
        subject4.setCode("PHSC12G");
        subject4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject4);
        
        Subject subject5 = new Subject();
        subject5.setCreatedBy("test");
        subject5.setCreatedDate(new Date());
        subject5.setName("Physical Science");
        subject5.setCode("PHSC10G");
        subject5.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject5);
        
        Subject subject6 = new Subject();
        subject6.setCreatedBy("test");
        subject6.setCreatedDate(new Date());
        subject6.setName("English");
        subject6.setCode("ENG11G");
        subject6.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject6);
        
        Subject subject7 = new Subject();
        subject7.setCreatedBy("test");
        subject7.setCreatedDate(new Date());
        subject7.setName("English");
        subject7.setCode("ENG10G");
        subject7.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject7);
        
        Subject subject8 = new Subject();
        subject8.setCreatedBy("test");
        subject8.setCreatedDate(new Date());
        subject8.setName("English");
        subject8.setCode("ENG12G");
        subject8.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject8);
        
        Subject subject9 = new Subject();
        subject9.setCreatedBy("test");
        subject9.setCreatedDate(new Date());
        subject9.setName("Economics");
        subject9.setCode("ECO12G");
        subject9.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject9);
        
        Subject subject10 = new Subject();
        subject10.setCreatedBy("test");
        subject10.setCreatedDate(new Date());
        subject10.setName("Economics");
        subject10.setCode("ECO10G");
        subject10.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject10);
        
        Subject subject11 = new Subject();
        subject11.setCreatedBy("test");
        subject11.setCreatedDate(new Date());
        subject11.setName("Economics");
        subject11.setCode("ECO11G");
        subject11.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject11);
        
        Subject subject12 = new Subject();
        subject12.setCreatedBy("test");
        subject12.setCreatedDate(new Date());
        subject12.setName("Business Studies");
        subject12.setCode("BSS10G");
        subject12.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject12);
        
        Subject subject13 = new Subject();
        subject13.setCreatedBy("test");
        subject13.setCreatedDate(new Date());
        subject13.setName("Business Studies");
        subject13.setCode("BSS12G");
        subject13.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        subjectRepository.save(subject13);
    }
}
