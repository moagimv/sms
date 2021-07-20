/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.sms.common.AddressType;
import za.gov.sars.sms.domain.Address;
import za.gov.sars.sms.domain.ContactDetail;
import za.gov.sars.sms.domain.Employee;
import za.gov.sars.sms.domain.SchoolSystemUser;
import za.gov.sars.sms.domain.Student;
import za.gov.sars.sms.service.EmployeeServiceLocal;
import za.gov.sars.sms.service.StudentServiceLocal;
import za.gov.sars.sms.service.SystemUserServiceLocal;

/**
 *
 * @author S2026987
 */
@ManagedBean
@ViewScoped
public class ProfileBean extends BaseBean {

    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private SystemUserServiceLocal systemUserService;

    private Employee staff;
    private Student student;
    private SchoolSystemUser systemUser;

    @PostConstruct
    public void init() {
        staff = employeeService.findEmployeeByEmployeeId(getActiveUser().getIdentifier());
        student = studentService.findStudentByStudentNo(getActiveUser().getIdentifier());
        systemUser = systemUserService.findSystemUserByIdentifier(getActiveUser().getIdentifier());
    }

    public void saveEmployee(Employee emp, SchoolSystemUser user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            emp.setUpdatedBy(getActiveUser().getIdentifier());
            emp.setUpdatedDate(new Date());
            employeeService.update(emp);

            user.setUpdatedBy(getActiveUser().getIdentifier());
            user.setUpdatedDate(new Date());
            user.setFirstName(emp.getFirstName());
            user.setLastName(emp.getLastName());
            user.setIdentityNo(emp.getIdentityNo());
            user.setIdentifier(emp.getEmployeeId());
            user.setGender(emp.getGender());

            for (Address address : emp.getAddresses()) {
                Address newAddress = new Address();
                newAddress.setCreatedBy(getActiveUser().getIdentifier());
                newAddress.setCreatedDate(new Date());
                newAddress.setAddressType(address.getAddressType());
                newAddress.setAddressLine1(address.getAddressLine1());
                newAddress.setAddressLine2(address.getAddressLine2());
                newAddress.setStreet(address.getStreet());
                newAddress.setArea(address.getArea());
                newAddress.setCode(address.getCode());

                user.addAddress(newAddress);
            }
            ContactDetail contactDetail = new ContactDetail();
            contactDetail.setCreatedBy(getActiveUser().getIdentifier());
            contactDetail.setCreatedDate(new Date());
            contactDetail.setCellphoneNo(emp.getContactDetail().getCellphoneNo());
            contactDetail.setTelephoneNo(emp.getContactDetail().getTelephoneNo());
            contactDetail.setEmail(emp.getContactDetail().getEmail());

            user.setContactDetail(contactDetail);

            systemUserService.update(user);
        } else {
            addWarningMessage("The password provided is not the same as the confimation password, please check your password and re-type again");
        }
    }

    public void saveStudent(Student std, SchoolSystemUser user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            std.setUpdatedBy(getActiveUser().getIdentifier());
            std.setUpdatedDate(new Date());
            studentService.update(std);
            
            user.setUpdatedBy(getActiveUser().getIdentifier());
            user.setUpdatedDate(new Date());
            user.setFirstName(std.getFirstName());
            user.setLastName(std.getLastName());
            user.setIdentityNo(std.getIdentityNo());
            user.setIdentifier(std.getStudentNo());
            user.setGender(std.getGender());

            for (Address address : std.getAddresses()) {
                Address newAddress = new Address();
                newAddress.setCreatedBy(getActiveUser().getIdentifier());
                newAddress.setCreatedDate(new Date());
                newAddress.setAddressType(address.getAddressType());
                newAddress.setAddressLine1(address.getAddressLine1());
                newAddress.setAddressLine2(address.getAddressLine2());
                newAddress.setStreet(address.getStreet());
                newAddress.setArea(address.getArea());
                newAddress.setCode(address.getCode());

                user.addAddress(newAddress);
            }
            ContactDetail contactDetail = new ContactDetail();
            contactDetail.setCreatedBy(getActiveUser().getIdentifier());
            contactDetail.setCreatedDate(new Date());
            contactDetail.setCellphoneNo(std.getContactDetail().getCellphoneNo());
            contactDetail.setTelephoneNo(std.getContactDetail().getTelephoneNo());
            contactDetail.setEmail(std.getContactDetail().getEmail());

            user.setContactDetail(contactDetail);
            
            systemUserService.update(user);
        } else {
            addWarningMessage("The password provided is not the same as the confimation password, please check your password and re-type again");
        }
    }

    public void cancel() {
        redirecting("/secured/landing");
    }

    public Employee getStaff() {
        return staff;
    }

    public void setStaff(Employee staff) {
        this.staff = staff;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public SchoolSystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SchoolSystemUser systemUser) {
        this.systemUser = systemUser;
    }
}
