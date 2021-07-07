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
import za.gov.sars.sms.domain.Grade;
import za.gov.sars.sms.service.GradeServiceLocal;

/**
 *
 * @author S2026987
 */
@ManagedBean
@ViewScoped
public class GradeBean extends BaseBean{
    @Autowired
    private GradeServiceLocal gradeService;
    
    private List<Grade> grades = new ArrayList<>();
    
    private Grade grade;
    
    @PostConstruct
    public void init(){
        this.resetView(false).setList(true);
        grades = gradeService.listAll();
    }
    
    public void addOrUpdate(Grade grd) {
        this.resetView(false).setAdd(true);
        if(grd != null){
            grd.setUpdatedBy(getActiveUser().getIdentifier());
            grd.setUpdatedDate(new Date());
            grade = grd;
        }
        else {
            grade = new Grade();
            grade.setCreatedBy(getActiveUser().getIdentifier());
            grade.setCreatedDate(new Date());
            
            grades.add(0, grade);
        }
    }
    
    public void save(Grade grd) {
        if (grd.getId() != null) {
            gradeService.update(grd);
        } else {
            gradeService.save(grd);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Grade grd) {
        gradeService.deleteById(grd.getId());
        synchronize(grd);
        this.resetView(false).setList(true);
    }

    public void synchronize(Grade grd) {
        Iterator<Grade> gradeList = grades.iterator();
        while (gradeList.hasNext()) {
            if (gradeList.next().getId().equals(grd.getId())) {
                gradeList.remove();
            }
        }
    }

    public void cancel(Grade grd) {
        if (grd.getId() == null) {
            if (grades.contains(grd)) {
                grades.remove(grd);
            }
        }
        this.resetView(false).setList(true);
    }

    public List<Grade> getGrades() {
        return grades;
    }

    public void setGrades(List<Grade> grades) {
        this.grades = grades;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
    
}
