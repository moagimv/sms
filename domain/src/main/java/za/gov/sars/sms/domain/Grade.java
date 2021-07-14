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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.envers.Audited;

/**
 *
 * @author S2026987
 */
@Audited
@Entity
@Table(name = "grade")
public class Grade extends BaseEntity{
    @Column(name = "designation")
    private String designation;
    @ManyToMany(mappedBy = "grades",cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Employee> educators = new ArrayList<>();
    @OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private List<Student> students = new ArrayList<>();
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    private School school;

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Employee> getEducators() {
        return educators;
    }

    public void setEducators(List<Employee> educators) {
        this.educators = educators;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
    
}
