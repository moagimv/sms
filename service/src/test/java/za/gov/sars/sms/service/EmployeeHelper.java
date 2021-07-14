/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.Date;
import za.gov.sars.sms.common.AddressType;
import za.gov.sars.sms.common.EmployeeType;
import za.gov.sars.sms.common.Gender;
import za.gov.sars.sms.common.PersonType;
import za.gov.sars.sms.domain.Address;
import za.gov.sars.sms.domain.ContactDetail;
import za.gov.sars.sms.domain.Employee;
import za.gov.sars.sms.persistence.EmployeeRepository;
import za.gov.sars.sms.persistence.GradeRepository;
import za.gov.sars.sms.persistence.SchoolRepository;
import za.gov.sars.sms.persistence.SubjectRepository;

/**
 *
 * @author S2026987
 */
public class EmployeeHelper {
    
    public static void addEmployee(EmployeeRepository employeeRepository, GradeRepository gradeRepository, SubjectRepository subjectRepository, SchoolRepository schoolRepository){
        Employee employee1 = new Employee();
        employee1.setCreatedBy("test");
        employee1.setCreatedDate(new Date());
        employee1.setEmployeeType(EmployeeType.EDUCATOR);
        employee1.setPersonType(PersonType.EMPLOYEE);
        employee1.setFirstName("Dukes");
        employee1.setLastName("Shai");
        employee1.setIdentityNo("8202155474088");
        employee1.setEmployee_id("00010");
        employee1.setSaceReg("1010");
        employee1.setGender(Gender.MALE);
        employee1.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        employee1.setGrades(gradeRepository.findAll());
        employee1.setSubjects(subjectRepository.findAll());
        
        Address ressAddress1 = new Address();
        ressAddress1.setAddressType(AddressType.RESIDENTIAL);
        ressAddress1.setCreatedBy("test");
        ressAddress1.setCreatedDate(new Date());
        ressAddress1.setAddressLine1("010 Block B");
        ressAddress1.setAddressLine2("School Complex");
        ressAddress1.setStreet("01 School Street");
        ressAddress1.setArea("School");
        ressAddress1.setCode("0001");
        
        Address postalAddress1 = new Address();
        postalAddress1.setAddressType(AddressType.POSTAL);
        postalAddress1.setCreatedBy("test");
        postalAddress1.setCreatedDate(new Date());
        postalAddress1.setAddressLine2("P.O Box 001");
        postalAddress1.setArea("School");
        postalAddress1.setCode("0001");
        
        employee1.addAddress(ressAddress1);
        employee1.addAddress(postalAddress1);
        
        ContactDetail contactDetail1 = new ContactDetail();
        contactDetail1.setCreatedBy("test");
        contactDetail1.setCreatedDate(new Date());
        contactDetail1.setCellphoneNo("0721234567");
        contactDetail1.setTelephoneNo("0121234567");
        contactDetail1.setEmail("dshai@school.gov.za");
        employee1.setContactDetail(contactDetail1);
        
        employeeRepository.save(employee1);
        
        
        Employee employee2 = new Employee();
        employee2.setCreatedBy("test");
        employee2.setCreatedDate(new Date());
        employee2.setEmployeeType(EmployeeType.HOD);
        employee2.setPersonType(PersonType.EMPLOYEE);
        employee2.setFirstName("Leslie");
        employee2.setLastName("Van Rensburg");
        employee2.setIdentityNo("8803255474081");
        employee2.setEmployee_id("00011");
        employee2.setSaceReg("1011");
        employee2.setGender(Gender.FEMALE);
        employee2.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        employee2.setGrades(gradeRepository.findAll());
        employee2.setSubjects(subjectRepository.findAll());
        
        Address ressAddress2 = new Address();
        ressAddress2.setAddressType(AddressType.RESIDENTIAL);
        ressAddress2.setCreatedBy("test");
        ressAddress2.setCreatedDate(new Date());
        ressAddress2.setAddressLine1("02 Block A");
        ressAddress2.setAddressLine2("School Complex");
        ressAddress2.setStreet("01 School Street");
        ressAddress2.setArea("School");
        ressAddress2.setCode("0001");
        
        Address postalAddress2 = new Address();
        postalAddress2.setAddressType(AddressType.POSTAL);
        postalAddress2.setCreatedBy("test");
        postalAddress2.setCreatedDate(new Date());
        postalAddress2.setAddressLine2("P.O Box 002");
        postalAddress2.setArea("School");
        postalAddress2.setCode("0001");
        
        employee2.addAddress(ressAddress2);
        employee2.addAddress(postalAddress2);
        
        ContactDetail contactDetail2 = new ContactDetail();
        contactDetail2.setCreatedBy("test");
        contactDetail2.setCreatedDate(new Date());
        contactDetail2.setCellphoneNo("0821232587");
        contactDetail2.setTelephoneNo("0121232587");
        contactDetail2.setEmail("lvanrensburg@school.gov.za");
        
        employee2.setContactDetail(contactDetail2);
        
        employeeRepository.save(employee2);
        
        
        Employee employee3 = new Employee();
        employee3.setCreatedBy("test");
        employee3.setCreatedDate(new Date());
        employee3.setEmployeeType(EmployeeType.PRINCIPAL);
        employee3.setPersonType(PersonType.EMPLOYEE);
        employee3.setFirstName("Rhendani");
        employee3.setLastName("Masia");
        employee3.setIdentityNo("8606305474085");
        employee3.setEmployee_id("00012");
        employee3.setSaceReg("1012");
        employee3.setGender(Gender.MALE);
        employee3.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        employee3.setGrades(gradeRepository.findAll());
        employee3.setSubjects(subjectRepository.findAll());
        
        Address ressAddress3 = new Address();
        ressAddress3.setAddressType(AddressType.RESIDENTIAL);
        ressAddress3.setCreatedBy("test");
        ressAddress3.setCreatedDate(new Date());
        ressAddress3.setAddressLine1("03 Block B");
        ressAddress3.setAddressLine2("School Complex");
        ressAddress3.setStreet("01 School Street");
        ressAddress3.setArea("School");
        ressAddress3.setCode("0001");
        
        Address postalAddress3 = new Address();
        postalAddress3.setAddressType(AddressType.POSTAL);
        postalAddress3.setCreatedBy("test");
        postalAddress3.setCreatedDate(new Date());
        postalAddress3.setAddressLine2("P.O Box 003");
        postalAddress3.setArea("School");
        postalAddress3.setCode("0001");
        
        employee3.addAddress(ressAddress3);
        employee3.addAddress(postalAddress3);
        
        ContactDetail contactDetail3 = new ContactDetail();
        contactDetail3.setCreatedBy("test");
        contactDetail3.setCreatedDate(new Date());
        contactDetail3.setCellphoneNo("0651234785");
        contactDetail3.setTelephoneNo("0121234785");
        contactDetail3.setEmail("rmasia@school.gov.za");
        
        employee3.setContactDetail(contactDetail3);
        
        employeeRepository.save(employee3);
        
        
        Employee employee4 = new Employee();
        employee4.setCreatedBy("test");
        employee4.setCreatedDate(new Date());
        employee4.setEmployeeType(EmployeeType.ADMIN);
        employee4.setPersonType(PersonType.EMPLOYEE);
        employee4.setFirstName("Qiniso");
        employee4.setLastName("Cele");
        employee4.setIdentityNo("8901315474086");
        employee4.setEmployee_id("00013");
        employee4.setSaceReg("1013");
        employee4.setGender(Gender.FEMALE);
        employee4.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        
        Address ressAddress4 = new Address();
        ressAddress4.setAddressType(AddressType.RESIDENTIAL);
        ressAddress4.setCreatedBy("test");
        ressAddress4.setCreatedDate(new Date());
        ressAddress4.setAddressLine1("04 Block A");
        ressAddress4.setAddressLine2("School Complex");
        ressAddress4.setStreet("01 School Street");
        ressAddress4.setArea("School");
        ressAddress4.setCode("0001");
        
        Address postalAddress4 = new Address();
        postalAddress4.setAddressType(AddressType.POSTAL);
        postalAddress4.setCreatedBy("test");
        postalAddress4.setCreatedDate(new Date());
        postalAddress4.setAddressLine2("P.O Box 004");
        postalAddress4.setArea("School");
        postalAddress4.setCode("0001");
        
        employee4.addAddress(ressAddress4);
        employee4.addAddress(postalAddress4);
        
        ContactDetail contactDetail4 = new ContactDetail();
        contactDetail4.setCreatedBy("test");
        contactDetail4.setCreatedDate(new Date());
        contactDetail4.setCellphoneNo("0741239685");
        contactDetail4.setTelephoneNo("0141239685");
        contactDetail4.setEmail("qcele@school.gov.za");
        
        employee4.setContactDetail(contactDetail4);
        
        employeeRepository.save(employee4);
        
        Employee employee5 = new Employee();
        employee5.setCreatedBy("test");
        employee5.setCreatedDate(new Date());
        employee5.setEmployeeType(EmployeeType.CLERK);
        employee5.setPersonType(PersonType.EMPLOYEE);
        employee5.setFirstName("Andile");
        employee5.setLastName("Soga");
        employee5.setIdentityNo("9403196742085");
        employee5.setEmployee_id("00015");
        employee5.setSaceReg("1015");
        employee5.setGender(Gender.MALE);
        employee5.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        
        Address ressAddress5 = new Address();
        ressAddress5.setAddressType(AddressType.RESIDENTIAL);
        ressAddress5.setCreatedBy("test");
        ressAddress5.setCreatedDate(new Date());
        ressAddress5.setAddressLine1("05 Block B");
        ressAddress5.setAddressLine2("School Complex");
        ressAddress5.setStreet("01 School Street");
        ressAddress5.setArea("School");
        ressAddress5.setCode("0001");
        
        Address postalAddress5 = new Address();
        postalAddress5.setAddressType(AddressType.POSTAL);
        postalAddress5.setCreatedBy("test");
        postalAddress5.setCreatedDate(new Date());
        postalAddress5.setAddressLine2("P.O Box 005");
        postalAddress5.setArea("School");
        postalAddress5.setCode("0001");
        
        employee5.addAddress(ressAddress5);
        employee5.addAddress(postalAddress5);
        
        ContactDetail contactDetail5 = new ContactDetail();
        contactDetail5.setCreatedBy("test");
        contactDetail5.setCreatedDate(new Date());
        contactDetail5.setCellphoneNo("0811231425");
        contactDetail5.setTelephoneNo("0111231425");
        contactDetail5.setEmail("asoga@school.gov.za");
        
        employee5.setContactDetail(contactDetail5);
        
        employeeRepository.save(employee5);
        
        Employee employee6 = new Employee();
        employee6.setCreatedBy("test");
        employee6.setCreatedDate(new Date());
        employee6.setEmployeeType(EmployeeType.GENERAL_WORKER);
        employee6.setPersonType(PersonType.EMPLOYEE);
        employee6.setFirstName("Jackson");
        employee6.setLastName("Mathews");
        employee6.setIdentityNo("9408095847087");
        employee6.setEmployee_id("00016");
        employee6.setSaceReg("1016");
        employee6.setGender(Gender.MALE);
        employee6.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        
        Address ressAddress6 = new Address();
        ressAddress6.setAddressType(AddressType.RESIDENTIAL);
        ressAddress6.setCreatedBy("test");
        ressAddress6.setCreatedDate(new Date());
        ressAddress6.setAddressLine1("06 Block A");
        ressAddress6.setAddressLine2("School Complex");
        ressAddress6.setStreet("01 School Street");
        ressAddress6.setArea("School");
        ressAddress6.setCode("0001");
        
        Address postalAddress6 = new Address();
        postalAddress6.setAddressType(AddressType.POSTAL);
        postalAddress6.setCreatedBy("test");
        postalAddress6.setCreatedDate(new Date());
        postalAddress6.setAddressLine2("P.O Box 006");
        postalAddress6.setArea("School");
        postalAddress6.setCode("0001");
        
        employee6.addAddress(ressAddress6);
        employee6.addAddress(postalAddress6);
        
        ContactDetail contactDetail6 = new ContactDetail();
        contactDetail6.setCreatedBy("test");
        contactDetail6.setCreatedDate(new Date());
        contactDetail6.setCellphoneNo("0611238564");
        contactDetail6.setTelephoneNo("0101238564");
        contactDetail6.setEmail("jmathews@school.gov.za");
        
        employee6.setContactDetail(contactDetail6);
        
        employeeRepository.save(employee6);
        
        Employee employee7 = new Employee();
        employee7.setCreatedBy("test");
        employee7.setCreatedDate(new Date());
        employee7.setEmployeeType(EmployeeType.ADMIN);
        employee7.setPersonType(PersonType.EMPLOYEE);
        employee7.setFirstName("Frans");
        employee7.setLastName("Du Toit");
        employee7.setIdentityNo("9912095847087");
        employee7.setEmployee_id("00017");
        employee7.setSaceReg("1017");
        employee7.setGender(Gender.MALE);
        employee7.setSchool(schoolRepository.findAll().get(schoolRepository.findAll().size() - 1));
        
        Address ressAddress7 = new Address();
        ressAddress7.setAddressType(AddressType.RESIDENTIAL);
        ressAddress7.setCreatedBy("test");
        ressAddress7.setCreatedDate(new Date());
        ressAddress7.setAddressLine1("07 Block B");
        ressAddress7.setAddressLine2("School Complex");
        ressAddress7.setStreet("01 School Street");
        ressAddress7.setArea("School");
        ressAddress7.setCode("0001");
        
        Address postalAddress7 = new Address();
        postalAddress7.setAddressType(AddressType.POSTAL);
        postalAddress7.setCreatedBy("test");
        postalAddress7.setCreatedDate(new Date());
        postalAddress7.setAddressLine2("P.O Box 006");
        postalAddress7.setArea("School");
        postalAddress7.setCode("0001");
        
        employee7.addAddress(ressAddress7);
        employee7.addAddress(postalAddress7);
        
        ContactDetail contactDetail7 = new ContactDetail();
        contactDetail7.setCreatedBy("test");
        contactDetail7.setCreatedDate(new Date());
        contactDetail7.setCellphoneNo("0611238564");
        contactDetail7.setTelephoneNo("0101238564");
        contactDetail7.setEmail("jmathews@school.gov.za");
        
        employee7.setContactDetail(contactDetail7);
        
        employeeRepository.save(employee7);
        
    }
}
