/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2026987
 */
@Audited
@Entity
@Table(name = "student")
public class Student extends Person{
    @Column(name = "student_number")
    private String studentNo;
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Grade grade;
    @OneToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private List<Subject> subjects = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private School school;

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
}
