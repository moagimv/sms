/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.domain;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2026987
 */
@Audited
@Entity
@Table(name = "assessment")
public class Assessment extends BaseEntity{
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "due_date")
    private Date dueDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "first_submission_date")
    private Date firsSubmissionDate;
    @Column(name = "full_mark")
    private Double fullMark;
    @Column(name = "pass_mark")
    private Double passMark;
    @Column(name = "student_mark")
    private Double studentMark;
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Grade grade;
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Subject subject;
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Student student;
    @OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private Employee educator;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Date getFirsSubmissionDate() {
        return firsSubmissionDate;
    }

    public void setFirsSubmissionDate(Date firsSubmissionDate) {
        this.firsSubmissionDate = firsSubmissionDate;
    }

    public Double getFullMark() {
        return fullMark;
    }

    public void setFullMark(Double fullMark) {
        this.fullMark = fullMark;
    }

    public Double getPassMark() {
        return passMark;
    }

    public void setPassMark(Double passMark) {
        this.passMark = passMark;
    }

    public Double getStudentMark() {
        return studentMark;
    }

    public void setStudentMark(Double studentMark) {
        this.studentMark = studentMark;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Employee getEducator() {
        return educator;
    }

    public void setEducator(Employee educator) {
        this.educator = educator;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
}
