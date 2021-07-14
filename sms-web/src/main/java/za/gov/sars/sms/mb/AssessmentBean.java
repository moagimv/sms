/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.mb;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.springframework.beans.factory.annotation.Autowired;
import za.gov.sars.sms.domain.Assessment;
import za.gov.sars.sms.domain.Employee;
import za.gov.sars.sms.domain.Grade;
import za.gov.sars.sms.domain.Student;
import za.gov.sars.sms.domain.Subject;
import za.gov.sars.sms.service.AssessmentServiceLocal;
import za.gov.sars.sms.service.EmployeeServiceLocal;
import za.gov.sars.sms.service.StudentServiceLocal;

/**
 *
 * @author S2026987
 */
@ManagedBean
@ViewScoped
public class AssessmentBean extends BaseBean {

    @Autowired
    private AssessmentServiceLocal assessmentService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private StudentServiceLocal studentService;

    private List<Assessment> assessments = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    private Assessment assessment;
    private Employee educator;
    private Student student;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        if (getActiveUser().isLearner()) {
            student = studentService.findStudentByStudentNo(getActiveUser().getIdentifier());
        } else {
            educator = employeeService.findEmployeeByEmployeeId(getActiveUser().getIdentifier());
        }

        if (educator != null) {
            assessments = retrieveEmpAssessments();
        } else if (student != null) {
            assessments = retrieveStudentAssessments();
        }
    }

    public void addOrUpdate(Assessment assess) {
        this.resetView(false).setAdd(true);
        if (assess != null) {
            assess.setUpdatedBy(getActiveUser().getIdentifier());
            assess.setUpdatedDate(new Date());
            assessment = assess;
        } else {
            assessment = new Assessment();
            assessment.setCreatedBy(getActiveUser().getIdentifier());
            assessment.setCreatedDate(new Date());
            assessment.setEducator(educator);

            assessments.add(0, assessment);
        }
    }

    public void addAssessment(Assessment assess) {
        
    }
    public void save(Assessment assess) {
        if (assess.getId() != null) {
            assess.setUpdatedBy(getActiveUser().getIdentifier());
            assess.setUpdatedDate(new Date());
            assessmentService.update(assess);
        } else {
            assessmentService.save(assess);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Assessment assess) {
        assessmentService.deleteById(assess.getId());
        synchronize(assess);
        this.resetView(false).setList(true);
    }

    public void synchronize(Assessment assess) {
        Iterator<Assessment> assessmentList = assessments.iterator();
        while (assessmentList.hasNext()) {
            if (assessmentList.next().getId().equals(assess.getId())) {
                assessmentList.remove();
            }
        }
    }

    public void cancel(Assessment assess) {
        if (assess.getId() == null) {
            if (assessments.contains(assess)) {
                assessments.remove(assess);
            }
        }
        this.resetView(false).setList(true);
    }
    
    
    public List<Assessment> retrieveEmpAssessments() {
        List<Assessment> assesses = new ArrayList<>();
        for (Assessment assess : assessmentService.listAll()) {
            if (assess.getEducator() != null && assess.getEducator().equals(educator)) {
                assesses.add(assess);
            }
        }
        return assesses;
    }

    public List<Assessment> retrieveStudentAssessments() {
        List<Assessment> assesses = new ArrayList<>();
        for (Assessment assess : assessmentService.listAll()) {
            if (assess.getStudent()!= null && assess.getStudent().equals(student)) {
                assesses.add(assess);
            }
        }
        return assesses;
    }
    
    public void gradeSelectionListener() {
        for(Student stud: studentService.listAll()){
            if(stud.getGrade().equals(assessment.getGrade())){
                for(Subject subject:stud.getSubjectsList()){
                    if(subject.equals(assessment.getSubject())){
                        students.add(stud);
                    }
                }                
            }
        }
        setVisible(true);
    }

    public List<Assessment> getAssessments() {
        return assessments;
    }

    public void setAssessments(List<Assessment> assessments) {
        this.assessments = assessments;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public Employee getEducator() {
        return educator;
    }

    public void setEducator(Employee educator) {
        this.educator = educator;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
