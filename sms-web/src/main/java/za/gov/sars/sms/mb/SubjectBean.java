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
import za.gov.sars.sms.domain.Subject;
import za.gov.sars.sms.service.SubjectServiceLocal;

/**
 *
 * @author S2026987
 */
@ManagedBean
@ViewScoped
public class SubjectBean extends BaseBean{
    @Autowired
    private SubjectServiceLocal subjectService;
    
    private List<Subject> subjects = new ArrayList<>();
    
    private Subject subject;
    
    @PostConstruct
    public void init(){
        this.resetView(false).setList(true);
        subjects = subjectService.listAll();
    }
    
    public void addOrUpdate(Subject sbjct){
        this.resetView(false).setAdd(true);
        if(sbjct != null){
            sbjct.setUpdatedBy(getActiveUser().getIdentifier());
            sbjct.setUpdatedDate(new Date());
            subject = sbjct;
        }
        else{
            subject = new Subject();
            subject.setCreatedBy(getActiveUser().getIdentifier());
            subject.setCreatedDate(new Date());
            
            subjects.add(0, subject);
        }
    }
    
    public void save(Subject sbjct) {
        if (sbjct.getId() != null) {
            subjectService.update(sbjct);
        } else {
            subjectService.save(sbjct);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Subject sbjct) {
        subjectService.deleteById(sbjct.getId());
        synchronize(sbjct);
        this.resetView(false).setList(true);
    }

    public void synchronize(Subject sbjct) {
        Iterator<Subject> subjectList = subjects.iterator();
        while (subjectList.hasNext()) {
            if (subjectList.next().getId().equals(sbjct.getId())) {
                subjectList.remove();
            }
        }
    }

    public void cancel(Subject sbjct) {
        if (sbjct.getId() == null) {
            if (subjects.contains(sbjct)) {
                subjects.remove(sbjct);
            }
        }
        this.resetView(false).setList(true);
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
}
