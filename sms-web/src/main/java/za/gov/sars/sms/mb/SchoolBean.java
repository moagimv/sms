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
import za.gov.sars.sms.domain.Facility;
import za.gov.sars.sms.domain.Grade;
import za.gov.sars.sms.domain.School;
import za.gov.sars.sms.domain.Student;
import za.gov.sars.sms.domain.Subject;
import za.gov.sars.sms.service.EmployeeServiceLocal;
import za.gov.sars.sms.service.FacilityServiceLocal;
import za.gov.sars.sms.service.GradeServiceLocal;
import za.gov.sars.sms.service.SchoolServiceLocal;
import za.gov.sars.sms.service.StudentServiceLocal;
import za.gov.sars.sms.service.SubjectServiceLocal;

/**
 *
 * @author S2026987
 */
@ManagedBean
@ViewScoped
public class SchoolBean extends BaseBean{
    @Autowired
    private SchoolServiceLocal schoolService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private SubjectServiceLocal subjectService;
    @Autowired
    private GradeServiceLocal gradeService;
    @Autowired
    private FacilityServiceLocal facilityService;
    
    private School school;
    
    List<Employee> employees = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Subject> subjects = new ArrayList<>();
    List<Grade> grades = new ArrayList<>();
    List<Facility> facilities = new ArrayList<>();
    
    @PostConstruct
    public void init(){
        this.resetView(false).setList(true);
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
        employees = employeeService.listAll();
        students = studentService.listAll();
        subjects = subjectService.listAll();
        grades = gradeService.listAll();
        facilities = facilityService.listAll();
    }
    
     public void addOrUpdate(School schul) {
        this.resetView(false).setAdd(true);
        if(schul != null){
            schul.setUpdatedBy(getActiveUser().getIdentifier());
            schul.setUpdatedDate(new Date());
            school = schul;
        }else{
            school = new School();
            school.setCreatedBy(getActiveUser().getIdentifier());
            school.setCreatedDate(new Date());
            
            Address physicalAddress = new Address();
            physicalAddress.setAddressType(AddressType.RESIDENTIAL);
            physicalAddress.setCreatedBy(getActiveUser().getIdentifier());
            physicalAddress.setCreatedDate(new Date());

            Address postalAddress = new Address();
            postalAddress.setAddressType(AddressType.POSTAL);
            postalAddress.setCreatedBy(getActiveUser().getIdentifier());
            postalAddress.setCreatedDate(new Date());
            
            school.addAddress(physicalAddress);
            school.addAddress(postalAddress);
            
            ContactDetail contactDetail = new ContactDetail();
            contactDetail.setCreatedBy(getActiveUser().getIdentifier());
            contactDetail.setCreatedDate(new Date());
            
            school.setContactDetail(contactDetail);
        }
     }
     
     public void save(School schul){
         if(schul.getId() != null){
             schoolService.update(schul);
         }else{
             schoolService.save(schul);
         }
         this.resetView(false).setList(true);
     }
     
     public void delete(School schul){
         schoolService.deleteById(schul.getId());
         this.resetView(false).setList(true);
     }
     
     public void cancel(){
         school = schoolService.listAll().get(schoolService.listAll().size() - 1);
         this.resetView(false).setList(true);
     }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
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

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }
    
    
}
