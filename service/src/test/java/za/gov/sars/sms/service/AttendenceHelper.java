/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.Date;
import za.gov.sars.sms.common.AttendanceStatus;
import za.gov.sars.sms.domain.Attendence;
import za.gov.sars.sms.persistence.AttendenceRepository;
import za.gov.sars.sms.persistence.EmployeeRepository;
import za.gov.sars.sms.persistence.GradeRepository;
import za.gov.sars.sms.persistence.StudentRepository;
import za.gov.sars.sms.persistence.SubjectRepository;

/**
 *
 * @author S2026987
 */
public class AttendenceHelper {
    
    public static void addAttendence(AttendenceRepository attendenceRepository, StudentRepository studentRepository, EmployeeRepository employeeRepository, GradeRepository gradeRepository, SubjectRepository subjectRepository){
        Attendence attendence1 = new Attendence();
        attendence1.setCreatedBy("test");
        attendence1.setCreatedDate(new Date());
        attendence1.setName("Mathematics Chapter 4 Lecture");
        attendence1.setDescription("A Mathematics Chapter 4 test cases attendence");
        attendence1.setStatus(AttendanceStatus.AVAILABLE);
        attendence1.setAttendanceDate(new Date());
        //attendence1.setStudents(studentRepository.findAll());
        attendence1.setEducator(employeeRepository.findAll().get(employeeRepository.findAll().size() - 7));
        //attendence1.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 1));
        //attendence1.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size() - 1));
        attendenceRepository.save(attendence1);
        
        Attendence attendence2 = new Attendence();
        attendence2.setCreatedBy("test");
        attendence2.setCreatedDate(new Date());
        attendence2.setName("Physical Science Chapter 8 Lecture");
        attendence2.setDescription("A Physical Science Chapter 8 test cases attendence");
        attendence2.setStatus(AttendanceStatus.CANCELLED);
        attendence2.setAttendanceDate(new Date());
        //attendence2.setStudents(studentRepository.findAll());
        attendence2.setEducator(employeeRepository.findAll().get(employeeRepository.findAll().size() - 7));
        //attendence2.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 2));
        //attendence2.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size() - 2));
        attendenceRepository.save(attendence2);
        
        Attendence attendence3 = new Attendence();
        attendence3.setCreatedBy("test");
        attendence3.setCreatedDate(new Date());
        attendence3.setName("Economics Chapter 1 Lecture");
        attendence3.setDescription("A Economics Chapter 1 test cases attendence");
        attendence3.setStatus(AttendanceStatus.POSTPONED);
        attendence3.setAttendanceDate(new Date());
        //attendence3.setStudents(studentRepository.findAll());
        attendence3.setEducator(employeeRepository.findAll().get(employeeRepository.findAll().size() - 7));
        //attendence3.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 3));
        //attendence3.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size() - 3));
        attendenceRepository.save(attendence3);
        
        Attendence attendence4 = new Attendence();
        attendence4.setCreatedBy("test");
        attendence4.setCreatedDate(new Date());
        attendence4.setName("English Chapter 1 Lecture");
        attendence4.setDescription("An English Chapter 1 test cases attendence");
        attendence4.setStatus(AttendanceStatus.SESSIONED);
        attendence4.setAttendanceDate(new Date());
        //attendence4.setStudents(studentRepository.findAll());
        attendence4.setEducator(employeeRepository.findAll().get(employeeRepository.findAll().size() - 7));
        //attendence4.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 3));
        //attendence4.setSubject(subjectRepository.findAll().get(subjectRepository.findAll().size() - 4));
        attendenceRepository.save(attendence4);
        
    }
}
