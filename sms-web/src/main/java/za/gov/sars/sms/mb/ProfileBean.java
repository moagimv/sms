/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.mb;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
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
            employeeService.update(emp);
            systemUserService.update(user);
        } else {
            addWarningMessage("The password provided is not the same as the confimation password, please check your password and re-type again");
        }
    }

    public void saveStudent(Student std, SchoolSystemUser user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            studentService.update(std);
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
