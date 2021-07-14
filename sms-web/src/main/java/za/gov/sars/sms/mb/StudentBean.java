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
import za.gov.sars.sms.domain.Address;
import za.gov.sars.sms.domain.ContactDetail;
import za.gov.sars.sms.domain.Grade;
import za.gov.sars.sms.domain.School;
import za.gov.sars.sms.domain.Student;
import za.gov.sars.sms.domain.Subject;
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
public class StudentBean extends BaseBean{
    
    @Autowired
    private StudentServiceLocal studentService;
    @Autowired
    private GradeServiceLocal gradeService;
    @Autowired
    private SubjectServiceLocal subjectService;
    @Autowired
    private SchoolServiceLocal schoolService;
    
    private List<Student> students = new ArrayList<>();
    private List<Grade> grades = new ArrayList<>();
    private List<Subject> subjects = new ArrayList<>();

    private List<AddressType> addressTypes;
    private List<Gender> genders;
    private List<PersonType> personTypes;
    
    private Student student;
    private School school;
    
    @PostConstruct
    public void init(){
        this.resetView(false).setList(true);
        students = studentService.listAll();
        grades = gradeService.listAll();
        subjects = subjectService.listAll();
        addressTypes = Arrays.asList(AddressType.values());
        genders = Arrays.asList(Gender.values());
        school = schoolService.listAll().get(schoolService.listAll().size() - 1);
    }

    public void addOrUpdate(Student std) {
        this.resetView(false).setAdd(true);
        if (std != null) {
            std.setUpdatedBy(getActiveUser().getIdentifier());
            std.setUpdatedDate(new Date());
            student = std;
        } else {
            student = new Student();
            student.setCreatedBy(getActiveUser().getIdentifier());
            student.setCreatedDate(new Date());
            student.setPersonType(PersonType.LEARNER);
            student.setSchool(school);
            
            Address physicalAddress = new Address();
            physicalAddress.setAddressType(AddressType.RESIDENTIAL);
            physicalAddress.setCreatedBy(getActiveUser().getIdentifier());
            physicalAddress.setCreatedDate(new Date());

            Address postalAddress = new Address();
            postalAddress.setAddressType(AddressType.POSTAL);
            postalAddress.setCreatedBy(getActiveUser().getIdentifier());
            postalAddress.setCreatedDate(new Date());
            
            student.addAddress(physicalAddress);
            student.addAddress(postalAddress);
            
            ContactDetail contactDetail = new ContactDetail();
            contactDetail.setCreatedBy(getActiveUser().getIdentifier());
            contactDetail.setCreatedDate(new Date());
            
            student.setContactDetail(contactDetail);
            
            students.add(0,student);
        }
    }
    
    public void save(Student std) {
        if (std.getId() != null) {
            studentService.update(std);
        } else {
            studentService.save(std);
        }
        this.resetView(false).setList(true);
    }
    
    public void delete(Student std) {
        studentService.deleteById(std.getId());
        synchronize(std);
        this.resetView(false).setList(true);
    }

    public void synchronize(Student std) {
        Iterator<Student> studentList = students.iterator();
        while (studentList.hasNext()) {
            if (studentList.next().getId().equals(std.getId())) {
                studentList.remove();
            }
        }
    }

    public void cancel(Student std) {
        if (std.getId() == null) {
            if (students.contains(std)) {
                students.remove(std);
            }
        }
        this.resetView(false).setList(true);
    }
    
    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
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

    public List<PersonType> getPersonTypes() {
        return personTypes;
    }

    public void setPersonTypes(List<PersonType> personTypes) {
        this.personTypes = personTypes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
}
