/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import za.gov.sars.sms.common.AddressType;
import za.gov.sars.sms.common.EmployeeType;
import za.gov.sars.sms.common.PersonType;
import za.gov.sars.sms.common.SystemUserStatus;
import za.gov.sars.sms.common.SystemUserType;
import za.gov.sars.sms.domain.Address;
import za.gov.sars.sms.domain.ContactDetail;
import za.gov.sars.sms.domain.Employee;
import za.gov.sars.sms.domain.SchoolSystemUser;
import za.gov.sars.sms.domain.Student;
import za.gov.sars.sms.persistence.EmployeeRepository;
import za.gov.sars.sms.persistence.StudentRepository;
import za.gov.sars.sms.persistence.SystemUserRepository;

/**
 *
 * @author S2026987
 */
public class SystemUserHelper {

    public static void addSystemUser(SystemUserRepository systemUserRepository, EmployeeRepository employeeRepository, StudentRepository studentRepository) {
        int count = 1;
        for (Employee emp : employeeRepository.findAll()) {
            if (emp.getEmployeeType().equals(EmployeeType.ADMIN)) {
                SchoolSystemUser systemUser1 = new SchoolSystemUser();
                systemUser1.setCreatedBy("test");
                systemUser1.setCreatedDate(new Date());
                systemUser1.setPersonType(PersonType.SYS_USER);
                systemUser1.setSystemUserStatus(SystemUserStatus.ACTIVE);
                systemUser1.setSystemUserType(SystemUserType.SYSTEM_ADMIN);
                systemUser1.setUsername("admin" + count);
                systemUser1.setPassword("admin" + count);
                systemUser1.setIdentifier(emp.getEmployeeId());
                systemUser1.setFirstName(emp.getFirstName());
                systemUser1.setLastName(emp.getLastName());
                systemUser1.setIdentityNo(emp.getIdentityNo());
                systemUser1.setGender(emp.getGender());

                for (Address address : emp.getAddresses()) {
                    Address newAddress = new Address();
                    newAddress.setCreatedBy("test");
                    newAddress.setCreatedDate(new Date());
                    newAddress.setAddressType(address.getAddressType());
                    newAddress.setAddressLine1(address.getAddressLine1());
                    newAddress.setAddressLine2(address.getAddressLine2());
                    newAddress.setStreet(address.getStreet());
                    newAddress.setArea(address.getArea());
                    newAddress.setCode(address.getCode());
                    systemUser1.addAddress(newAddress);
                }

                ContactDetail contactDetail = new ContactDetail();
                contactDetail.setCreatedBy("test");
                contactDetail.setCreatedDate(new Date());
                contactDetail.setCellphoneNo(emp.getContactDetail().getCellphoneNo());
                contactDetail.setTelephoneNo(emp.getContactDetail().getTelephoneNo());
                contactDetail.setEmail(emp.getContactDetail().getEmail());
                systemUser1.setContactDetail(contactDetail);

                systemUserRepository.save(systemUser1);
                count++;
            }

            if (emp.getEmployeeType().equals(EmployeeType.EDUCATOR)) {
                SchoolSystemUser systemUser2 = new SchoolSystemUser();
                systemUser2.setCreatedBy("test");
                systemUser2.setCreatedDate(new Date());
                systemUser2.setPersonType(PersonType.SYS_USER);
                systemUser2.setSystemUserStatus(SystemUserStatus.ACTIVE);
                systemUser2.setSystemUserType(SystemUserType.EMPLOYEE);
                systemUser2.setUsername("employee" + count);
                systemUser2.setPassword("employee" + count);
                systemUser2.setIdentifier(emp.getEmployeeId());
                systemUser2.setFirstName(emp.getFirstName());
                systemUser2.setLastName(emp.getLastName());
                systemUser2.setIdentityNo(emp.getIdentityNo());
                systemUser2.setGender(emp.getGender());

                for (Address address : emp.getAddresses()) {
                    Address newAddress = new Address();
                    newAddress.setCreatedBy("test");
                    newAddress.setCreatedDate(new Date());
                    newAddress.setAddressType(address.getAddressType());
                    newAddress.setAddressLine1(address.getAddressLine1());
                    newAddress.setAddressLine2(address.getAddressLine2());
                    newAddress.setStreet(address.getStreet());
                    newAddress.setArea(address.getArea());
                    newAddress.setCode(address.getCode());
                    systemUser2.addAddress(newAddress);
                }

                ContactDetail contactDetail = new ContactDetail();
                contactDetail.setCreatedBy("test");
                contactDetail.setCreatedDate(new Date());
                contactDetail.setCellphoneNo(emp.getContactDetail().getCellphoneNo());
                contactDetail.setTelephoneNo(emp.getContactDetail().getTelephoneNo());
                contactDetail.setEmail(emp.getContactDetail().getEmail());
                systemUser2.setContactDetail(contactDetail);
                systemUserRepository.save(systemUser2);
                count++;
            }

            if (emp.getEmployeeType().equals(EmployeeType.HOD)) {
                SchoolSystemUser systemUser3 = new SchoolSystemUser();
                systemUser3.setCreatedBy("test");
                systemUser3.setCreatedDate(new Date());
                systemUser3.setPersonType(PersonType.SYS_USER);
                systemUser3.setSystemUserStatus(SystemUserStatus.INACTIVE);
                systemUser3.setSystemUserType(SystemUserType.EMPLOYEE);
                systemUser3.setUsername("employee" + count);
                systemUser3.setPassword("employee" + count);
                systemUser3.setIdentifier(emp.getEmployeeId());
                systemUser3.setFirstName(emp.getFirstName());
                systemUser3.setLastName(emp.getLastName());
                systemUser3.setIdentityNo(emp.getIdentityNo());
                systemUser3.setGender(emp.getGender());

                for (Address address : emp.getAddresses()) {
                    Address newAddress = new Address();
                    newAddress.setCreatedBy("test");
                    newAddress.setCreatedDate(new Date());
                    newAddress.setAddressType(address.getAddressType());
                    newAddress.setAddressLine1(address.getAddressLine1());
                    newAddress.setAddressLine2(address.getAddressLine2());
                    newAddress.setStreet(address.getStreet());
                    newAddress.setArea(address.getArea());
                    newAddress.setCode(address.getCode());
                    systemUser3.addAddress(newAddress);
                }

                ContactDetail contactDetail = new ContactDetail();
                contactDetail.setCreatedBy("test");
                contactDetail.setCreatedDate(new Date());
                contactDetail.setCellphoneNo(emp.getContactDetail().getCellphoneNo());
                contactDetail.setTelephoneNo(emp.getContactDetail().getTelephoneNo());
                contactDetail.setEmail(emp.getContactDetail().getEmail());
                systemUser3.setContactDetail(contactDetail);
                systemUserRepository.save(systemUser3);
                count++;
            }

            if (emp.getEmployeeType().equals(EmployeeType.PRINCIPAL)) {
                SchoolSystemUser systemUser4 = new SchoolSystemUser();
                systemUser4.setCreatedBy("test");
                systemUser4.setCreatedDate(new Date());
                systemUser4.setPersonType(PersonType.SYS_USER);
                systemUser4.setSystemUserStatus(SystemUserStatus.SUSPEDEND);
                systemUser4.setSystemUserType(SystemUserType.EMPLOYEE);
                systemUser4.setUsername("employee" + count);
                systemUser4.setPassword("employee" + count);
                systemUser4.setIdentifier(emp.getEmployeeId());
                systemUser4.setFirstName(emp.getFirstName());
                systemUser4.setLastName(emp.getLastName());
                systemUser4.setIdentityNo(emp.getIdentityNo());
                systemUser4.setGender(emp.getGender());

                for (Address address : emp.getAddresses()) {
                    Address newAddress = new Address();
                    newAddress.setCreatedBy("test");
                    newAddress.setCreatedDate(new Date());
                    newAddress.setAddressType(address.getAddressType());
                    newAddress.setAddressLine1(address.getAddressLine1());
                    newAddress.setAddressLine2(address.getAddressLine2());
                    newAddress.setStreet(address.getStreet());
                    newAddress.setArea(address.getArea());
                    newAddress.setCode(address.getCode());
                    systemUser4.addAddress(newAddress);
                }

                ContactDetail contactDetail = new ContactDetail();
                contactDetail.setCreatedBy("test");
                contactDetail.setCreatedDate(new Date());
                contactDetail.setCellphoneNo(emp.getContactDetail().getCellphoneNo());
                contactDetail.setTelephoneNo(emp.getContactDetail().getTelephoneNo());
                contactDetail.setEmail(emp.getContactDetail().getEmail());
                systemUser4.setContactDetail(contactDetail);
                systemUserRepository.save(systemUser4);
                count++;
            }
        }

        count = 1;
        for (Student student : studentRepository.findAll()) {
            SchoolSystemUser systemUser5 = new SchoolSystemUser();
            systemUser5.setCreatedBy("test");
            systemUser5.setCreatedDate(new Date());
            systemUser5.setPersonType(PersonType.SYS_USER);
            systemUser5.setSystemUserStatus(SystemUserStatus.ACTIVE);
            systemUser5.setSystemUserType(SystemUserType.LEARNER);
            systemUser5.setUsername("learner" + count);
            systemUser5.setPassword("learner" + count);
            systemUser5.setIdentifier(student.getStudentNo());
            systemUser5.setFirstName(student.getFirstName());
            systemUser5.setLastName(student.getLastName());
            systemUser5.setIdentityNo(student.getIdentityNo());
            systemUser5.setGender(student.getGender());

            for (Address address : student.getAddresses()) {
                Address newAddress = new Address();
                newAddress.setCreatedBy("test");
                newAddress.setCreatedDate(new Date());
                newAddress.setAddressType(address.getAddressType());
                newAddress.setAddressLine1(address.getAddressLine1());
                newAddress.setAddressLine2(address.getAddressLine2());
                newAddress.setStreet(address.getStreet());
                newAddress.setArea(address.getArea());
                newAddress.setCode(address.getCode());
                systemUser5.addAddress(newAddress);
            }

            ContactDetail contactDetail = new ContactDetail();
            contactDetail.setCreatedBy("test");
            contactDetail.setCreatedDate(new Date());
            contactDetail.setCellphoneNo(student.getContactDetail().getCellphoneNo());
            contactDetail.setTelephoneNo(student.getContactDetail().getTelephoneNo());
            contactDetail.setEmail(student.getContactDetail().getEmail());
            systemUser5.setContactDetail(contactDetail);
            systemUserRepository.save(systemUser5);
            count++;
        }
    }
}
