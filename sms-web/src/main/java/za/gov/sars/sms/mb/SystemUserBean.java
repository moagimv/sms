/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.mb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.sms.common.AddressType;
import za.gov.sars.sms.common.Gender;
import za.gov.sars.sms.common.PersonType;
import za.gov.sars.sms.common.SystemUserStatus;
import za.gov.sars.sms.common.SystemUserType;
import za.gov.sars.sms.domain.Address;
import za.gov.sars.sms.domain.ContactDetail;
import za.gov.sars.sms.domain.Employee;
import za.gov.sars.sms.domain.School;
import za.gov.sars.sms.domain.SchoolSystemUser;
import za.gov.sars.sms.domain.Student;
import za.gov.sars.sms.service.EmployeeServiceLocal;
import za.gov.sars.sms.service.GradeServiceLocal;
import za.gov.sars.sms.service.SchoolServiceLocal;
import za.gov.sars.sms.service.StudentServiceLocal;
import za.gov.sars.sms.service.SubjectServiceLocal;
import za.gov.sars.sms.service.SystemUserServiceLocal;

/**
 *
 * @author S2026987
 */
@ManagedBean
@ViewScoped
public class SystemUserBean extends BaseBean {

    @Autowired
    private SystemUserServiceLocal systemUserService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private SchoolServiceLocal schoolService;

    private List<SchoolSystemUser> systemUsers = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    private List<AddressType> addressTypes;
    private List<Gender> genders;
    private List<SystemUserType> systemUserTypes;
    private List<SystemUserStatus> systemUserStatuses;

    private School school;

    private SchoolSystemUser systemUser;
    private Employee staff;
    private Student student;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        systemUsers = systemUserService.listAll();
        employees = employeeService.listAll();
        students = studentService.listAll();
        addressTypes = Arrays.asList(AddressType.values());
        genders = Arrays.asList(Gender.values());
        systemUserTypes = Arrays.asList(SystemUserType.values());
        systemUserStatuses = Arrays.asList(SystemUserStatus.values());
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
    }

    public void addOrUpdate(SchoolSystemUser user) {
        this.resetView(false).setAdd(true);
        if (user != null) {
            if (user.getSystemUserType().equals(SystemUserType.EMPLOYEE)) {
                staff = employeeService.findEmployeeByEmployeeId(user.getIdentifier());
            } else if (user.getSystemUserType().equals(SystemUserType.SYSTEM_ADMIN)) {
                staff = employeeService.findEmployeeByEmployeeId(user.getIdentifier());
            } else if (user.getSystemUserType().equals(SystemUserType.LEARNER)) {
                student = studentService.findStudentByStudentNo(user.getIdentifier());
            }
            user.setUpdatedBy(getActiveUser().getIdentifier());
            user.setUpdatedDate(new Date());
            systemUser = user;
        } else {
            systemUser = new SchoolSystemUser();
            systemUser.setCreatedBy("");
            systemUser.setCreatedDate(new Date());
            systemUser.setSchool(school);
            systemUser.setPersonType(PersonType.SYS_USER);

            systemUsers.add(0, systemUser);
        }
    }

    public void save(SchoolSystemUser user) {
        if (user.getPassword().equals(user.getConfirmPassword())) {
            if (user.getId() != null) {
                user.setUpdatedBy(getActiveUser().getIdentifier());
                user.setUpdatedDate(new Date());
                systemUserService.update(user);
            } else {
                if (userExist(user)) {
                    if (user.getSystemUserType().equals(SystemUserType.EMPLOYEE) || user.getSystemUserType().equals(SystemUserType.SYSTEM_ADMIN)) {
                        staff = employeeService.findEmployeeByEmployeeId(user.getIdentifier());
                        user.setFirstName(staff.getFirstName());
                        user.setLastName(staff.getLastName());
                        user.setIdentityNo(staff.getIdentityNo());
                        user.setGender(staff.getGender());

                        for (Address address : staff.getAddresses()) {
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
                        contactDetail.setCellphoneNo(staff.getContactDetail().getCellphoneNo());
                        contactDetail.setTelephoneNo(staff.getContactDetail().getTelephoneNo());
                        contactDetail.setEmail(staff.getContactDetail().getEmail());
                        user.setContactDetail(contactDetail);

                        systemUserService.save(user);
                    } else if (user.getSystemUserType().equals(SystemUserType.LEARNER)) {
                        student = studentService.findStudentByStudentNo(user.getIdentifier());
                        user.setFirstName(student.getFirstName());
                        user.setLastName(student.getLastName());
                        user.setIdentityNo(student.getIdentityNo());
                        user.setGender(student.getGender());

                        for (Address address : student.getAddresses()) {
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
                        contactDetail.setCellphoneNo(student.getContactDetail().getCellphoneNo());
                        contactDetail.setTelephoneNo(student.getContactDetail().getTelephoneNo());
                        contactDetail.setEmail(student.getContactDetail().getEmail());
                        user.setContactDetail(contactDetail);

                        systemUserService.save(user);
                    }
                } else {
                    addWarningMessage("The person you are trying to register already exist as a user.");
                }
            }
            this.resetView(false).setList(true);
        } else {
            addWarningMessage("The password provided is not the same as the confimation password, please check your password and re-type again.");
        }
    }

    public void delete(SchoolSystemUser user) {
        systemUserService.deleteById(user.getId());
        this.resetView(false).setList(true);
    }

    public void synchronize(SchoolSystemUser user) {
        Iterator<SchoolSystemUser> userList = systemUsers.iterator();
        while (userList.hasNext()) {
            if (userList.next().getId().equals(user.getId())) {
                userList.remove();
            }
        }
    }

    public void cancel(SchoolSystemUser user) {
        if (user.getId() == null) {
            if (systemUsers.contains(user)) {
                systemUsers.remove(user);
            }
        }
        this.resetView(false).setList(true);
    }

    public List<String> getIdentifiers() {
        List<String> allIdentities = new ArrayList<>();
        for (SchoolSystemUser user : systemUserService.listAll()) {
            allIdentities.add(user.getIdentifier());
        }
        return allIdentities;
    }

    public void systemUserTypeListener() {
        if (systemUser.getSystemUserType().equals(SystemUserType.EMPLOYEE) || systemUser.getSystemUserType().equals(SystemUserType.SYSTEM_ADMIN)) {
            setVisibleTab(false);
            setVisible(true);
        } else if (systemUser.getSystemUserType().equals(SystemUserType.LEARNER)) {
            setVisible(false);
            setVisibleTab(true);
        }
    }

    public boolean userExist(SchoolSystemUser user) {
        for (SchoolSystemUser sysUser : systemUserService.listAll()) {
            if (user.getIdentifier().equals(sysUser.getIdentifier())) {
                return true;
            }
        }
        return false;
    }

    public List<SchoolSystemUser> getSystemUsers() {
        return systemUsers;
    }

    public void setSystemUsers(List<SchoolSystemUser> systemUsers) {
        this.systemUsers = systemUsers;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public SchoolSystemUser getSystemUser() {
        return systemUser;
    }

    public void setSystemUser(SchoolSystemUser systemUser) {
        this.systemUser = systemUser;
    }

    public List<AddressType> getAddressTypes() {
        return addressTypes;
    }

    public void setAddressTypes(List<AddressType> addressTypes) {
        this.addressTypes = addressTypes;
    }

    public List<Gender> getGenders() {
        return genders;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public List<SystemUserType> getSystemUserTypes() {
        return systemUserTypes;
    }

    public void setSystemUserTypes(List<SystemUserType> systemUserTypes) {
        this.systemUserTypes = systemUserTypes;
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

    public List<SystemUserStatus> getSystemUserStatuses() {
        return systemUserStatuses;
    }

    public void setSystemUserStatuses(List<SystemUserStatus> systemUserStatuses) {
        this.systemUserStatuses = systemUserStatuses;
    }

}
