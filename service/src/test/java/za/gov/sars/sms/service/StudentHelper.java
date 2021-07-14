/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.Date;
import za.gov.sars.sms.common.AddressType;
import za.gov.sars.sms.common.Gender;
import za.gov.sars.sms.common.PersonType;
import za.gov.sars.sms.domain.Address;
import za.gov.sars.sms.domain.ContactDetail;
import za.gov.sars.sms.domain.Student;
import za.gov.sars.sms.persistence.GradeRepository;
import za.gov.sars.sms.persistence.SchoolRepository;
import za.gov.sars.sms.persistence.StudentRepository;
import za.gov.sars.sms.persistence.SubjectRepository;

/**
 *
 * @author S2026987
 */
public class StudentHelper {
    
    public static void addStudent(StudentRepository studentRepository,  GradeRepository gradeRepository, SubjectRepository subjectRepository, SchoolRepository schoolRepository){
        Student student1 = new Student();
        student1.setCreatedBy("test");
        student1.setCreatedDate(new Date());
        student1.setPersonType(PersonType.LEARNER);
        student1.setFirstName("Matome");
        student1.setLastName("Raboya");
        student1.setIdentityNo("0511205463081");
        student1.setStudentNo("10010");
        student1.setGender(Gender.MALE);
        student1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student1.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 1));
        student1.setSubjectsList(subjectRepository.findAll());
        
        ContactDetail contactDetail1 = new ContactDetail();
        contactDetail1.setCreatedBy("test");
        contactDetail1.setCreatedDate(new Date());
        contactDetail1.setCellphoneNo("060784296");
        contactDetail1.setTelephoneNo("012784296");
        contactDetail1.setEmail("mraboya@school.gov.za");
        
        student1.setContactDetail(contactDetail1);
        
        Address ressAddress1 = new Address();
        ressAddress1.setAddressType(AddressType.RESIDENTIAL);
        ressAddress1.setCreatedBy("test");
        ressAddress1.setCreatedDate(new Date());
        ressAddress1.setAddressLine1("01 Block C");
        ressAddress1.setAddressLine2("School Ress");
        ressAddress1.setStreet("02 School Street");
        ressAddress1.setArea("School");
        ressAddress1.setCode("0001");
        
        Address postalAddress1 = new Address();
        postalAddress1.setCreatedBy("test");
        postalAddress1.setCreatedDate(new Date());
        postalAddress1.setAddressLine2("P.O Box 100");
        postalAddress1.setArea("School");
        postalAddress1.setCode("0001");
        postalAddress1.setAddressType(AddressType.POSTAL);
        
        student1.addAddress(ressAddress1);
        student1.addAddress(postalAddress1);
        
        studentRepository.save(student1);
        
        Student student2 = new Student();
        student2.setCreatedBy("test");
        student2.setCreatedDate(new Date());
        student2.setPersonType(PersonType.LEARNER);
        student2.setFirstName("Mashudu");
        student2.setLastName("Ndou");
        student2.setIdentityNo("0605249641080");
        student2.setStudentNo("10011");
        student2.setGender(Gender.FEMALE);
        student2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student2.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 2));
        student2.setSubjectsList(subjectRepository.findAll());
        
        ContactDetail contactDetail2 = new ContactDetail();
        contactDetail2.setCreatedBy("test");
        contactDetail2.setCreatedDate(new Date());
        contactDetail2.setCellphoneNo("0658954347");
        contactDetail2.setTelephoneNo("0158954347");
        contactDetail2.setEmail("mndou@school.gov.za");
        
        student2.setContactDetail(contactDetail2);
        
        Address ressAddress2 = new Address();
        ressAddress2.setCreatedBy("test");
        ressAddress2.setCreatedDate(new Date());
        ressAddress2.setAddressLine1("02 Block D");
        ressAddress2.setAddressLine2("School Ress");
        ressAddress2.setStreet("02 School Street");
        ressAddress2.setArea("School");
        ressAddress2.setCode("0001");
        ressAddress2.setAddressType(AddressType.RESIDENTIAL);
        
        Address postalAddress2 = new Address();
        postalAddress2.setCreatedBy("test");
        postalAddress2.setCreatedDate(new Date());
        postalAddress2.setAddressLine2("P.O Box 101");
        postalAddress2.setArea("School");
        postalAddress2.setCode("0001");
        postalAddress2.setAddressType(AddressType.POSTAL);
        
        student2.addAddress(ressAddress2);
        student2.addAddress(postalAddress2);
                
        studentRepository.save(student2);
        
        Student student3 = new Student();
        student3.setCreatedBy("test");
        student3.setCreatedDate(new Date());
        student3.setPersonType(PersonType.LEARNER);
        student3.setFirstName("Nompilo");
        student3.setLastName("Chauke");
        student3.setIdentityNo("0402285416084");
        student3.setStudentNo("10012");
        student3.setGender(Gender.FEMALE);
        student3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student3.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 3));
        student3.setSubjectsList(subjectRepository.findAll());
        
        ContactDetail contactDetail3 = new ContactDetail();
        contactDetail3.setCreatedBy("test");
        contactDetail3.setCreatedDate(new Date());
        contactDetail3.setCellphoneNo("0819685142");
        contactDetail3.setTelephoneNo("0119685142");
        contactDetail3.setEmail("nchauke@school.gov.za");
        
        student3.setContactDetail(contactDetail3);
        
        Address ressAddress3 = new Address();
        ressAddress3.setCreatedBy("test");
        ressAddress3.setCreatedDate(new Date());
        ressAddress3.setAddressLine1("03 Block C");
        ressAddress3.setAddressLine2("School Ress");
        ressAddress3.setStreet("02 School Street");
        ressAddress3.setArea("School");
        ressAddress3.setCode("0001");
        ressAddress3.setAddressType(AddressType.RESIDENTIAL);
        
        Address postalAddress3 = new Address();
        postalAddress3.setCreatedBy("test");
        postalAddress3.setCreatedDate(new Date());
        postalAddress3.setAddressLine2("P.O Box 102");
        postalAddress3.setArea("School");
        postalAddress3.setCode("0001");
        postalAddress3.setAddressType(AddressType.POSTAL);
        
        student3.addAddress(ressAddress3);
        student3.addAddress(postalAddress3);
        
        studentRepository.save(student3);
        
        Student student4 = new Student();
        student4.setCreatedBy("test");
        student4.setCreatedDate(new Date());
        student4.setPersonType(PersonType.LEARNER);
        student4.setFirstName("Ntsako");
        student4.setLastName("Bvuma");
        student4.setIdentityNo("1007095241081");
        student4.setStudentNo("10013");
        student4.setGender(Gender.MALE);
        student4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student4.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 4));
        student4.setSubjectsList(subjectRepository.findAll());
        
        ContactDetail contactDetail4 = new ContactDetail();
        contactDetail4.setCreatedBy("test");
        contactDetail4.setCreatedDate(new Date());
        contactDetail4.setCellphoneNo("06584376128");
        contactDetail4.setTelephoneNo("01584376128");
        contactDetail4.setEmail("nbvuma@school.gov.za");
        
        student4.setContactDetail(contactDetail4);
        
        Address ressAddress4 = new Address();
        ressAddress4.setCreatedBy("test");
        ressAddress4.setCreatedDate(new Date());
        ressAddress4.setAddressLine1("04 Block D");
        ressAddress4.setAddressLine2("School Ress");
        ressAddress4.setStreet("02 School Street");
        ressAddress4.setArea("School");
        ressAddress4.setCode("0001");
        ressAddress4.setAddressType(AddressType.RESIDENTIAL);
        
        Address postalAddress4 = new Address();
        postalAddress4.setCreatedBy("test");
        postalAddress4.setCreatedDate(new Date());
        postalAddress4.setAddressLine2("P.O Box 103");
        postalAddress4.setArea("School");
        postalAddress4.setCode("0001");
        postalAddress4.setAddressType(AddressType.POSTAL);
        
        student4.addAddress(ressAddress4);
        student4.addAddress(postalAddress4);
        
        studentRepository.save(student4);
        
        Student student5 = new Student();
        student5.setCreatedBy("test");
        student5.setCreatedDate(new Date());
        student5.setPersonType(PersonType.LEARNER);
        student5.setFirstName("Edzani");
        student5.setLastName("Mutemula");
        student5.setIdentityNo("0810108547088");
        student5.setStudentNo("10014");
        student5.setGender(Gender.MALE);
        student5.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student5.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 1));
        student5.setSubjectsList(subjectRepository.findAll());
        
        ContactDetail contactDetail5 = new ContactDetail();
        contactDetail5.setCreatedBy("test");
        contactDetail5.setCreatedDate(new Date());
        contactDetail5.setCellphoneNo("0728137654");
        contactDetail5.setTelephoneNo("0128137654");
        contactDetail5.setEmail("emutemula@school.gov.za");
        
        student5.setContactDetail(contactDetail5);
        
        Address ressAddress5 = new Address();
        ressAddress5.setCreatedBy("test");
        ressAddress5.setCreatedDate(new Date());
        ressAddress5.setAddressLine1("05 Block C");
        ressAddress5.setAddressLine2("School Ress");
        ressAddress5.setStreet("02 School Street");
        ressAddress5.setArea("School");
        ressAddress5.setCode("0001");
        ressAddress5.setAddressType(AddressType.RESIDENTIAL);
        
        Address postalAddress5 = new Address();
        postalAddress5.setCreatedBy("test");
        postalAddress5.setCreatedDate(new Date());
        postalAddress5.setAddressLine2("P.O Box 104");
        postalAddress5.setArea("School");
        postalAddress5.setCode("0001");
        postalAddress5.setAddressType(AddressType.POSTAL);
        
        student5.addAddress(ressAddress5);
        student5.addAddress(postalAddress5);
        
        studentRepository.save(student5);
        
        Student student6 = new Student();
        student6.setCreatedBy("test");
        student6.setCreatedDate(new Date());
        student6.setPersonType(PersonType.LEARNER);
        student6.setFirstName("Nontsikelelo");
        student6.setLastName("Maphumulo");
        student6.setIdentityNo("1201017485080");
        student6.setStudentNo("10015");
        student6.setGender(Gender.FEMALE);
        student6.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        student6.setGrade(gradeRepository.findAll().get(gradeRepository.findAll().size() - 2));
        student6.setSubjectsList(subjectRepository.findAll());
        
        ContactDetail contactDetail6 = new ContactDetail();
        contactDetail6.setCreatedBy("test");
        contactDetail6.setCreatedDate(new Date());
        contactDetail6.setCellphoneNo("0718536147");
        contactDetail6.setTelephoneNo("0148536147");
        contactDetail6.setEmail("nmaphumulo@school.gov.za");
        
        student6.setContactDetail(contactDetail6);
        
        Address ressAddress6 = new Address();
        ressAddress6.setCreatedBy("test");
        ressAddress6.setCreatedDate(new Date());
        ressAddress6.setAddressLine1("06 Block D");
        ressAddress6.setAddressLine2("School Ress");
        ressAddress6.setStreet("02 School Street");
        ressAddress6.setArea("School");
        ressAddress6.setCode("0001");
        ressAddress6.setAddressType(AddressType.RESIDENTIAL);
        
        Address postalAddress6 = new Address();
        postalAddress6.setCreatedBy("test");
        postalAddress6.setCreatedDate(new Date());
        postalAddress6.setAddressLine2("P.O Box 105");
        postalAddress6.setArea("School");
        postalAddress6.setCode("0001");
        postalAddress6.setAddressType(AddressType.POSTAL);
        
        student6.addAddress(ressAddress6);
        student6.addAddress(postalAddress6);
        
        studentRepository.save(student6);
        
    }
}
