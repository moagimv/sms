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
import za.gov.sars.sms.common.AttendanceStatus;
import za.gov.sars.sms.domain.Attendence;
import za.gov.sars.sms.domain.Employee;
import za.gov.sars.sms.domain.Facility;
import za.gov.sars.sms.domain.Student;
import za.gov.sars.sms.service.AttendenceServiceLocal;
import za.gov.sars.sms.service.EmployeeServiceLocal;
import za.gov.sars.sms.service.FacilityServiceLocal;
import za.gov.sars.sms.service.StudentServiceLocal;

/**
 *
 * @author S2026987
 */
@ManagedBean
@ViewScoped
public class AttendenceBean extends BaseBean {

    @Autowired
    private AttendenceServiceLocal attendenceService;
    @Autowired
    private EmployeeServiceLocal employeeService;
    @Autowired
    private FacilityServiceLocal facilityService;
    @Autowired
    private StudentServiceLocal studentService;

    private List<Attendence> attendences = new ArrayList<>();
    private List<Attendence> allAttendences = new ArrayList<>();
    private List<Facility> Facilities = new ArrayList<>();
    private List<AttendanceStatus> attendanceStatuses = new ArrayList<>();
            
    private Attendence attendence;
    private Employee educator;
    private Student student;

    @PostConstruct
    public void init() {
        this.resetView(false).setList(true);
        allAttendences = attendenceService.listAll();
        if (getActiveUser().isLearner()) {
            student = studentService.findStudentByStudentNo(getActiveUser().getIdentifier());
        } else {
            educator = employeeService.findEmployeeByEmployeeId(getActiveUser().getIdentifier());
        }        
        if (educator != null) {
            attendences = attendenceService.findAttendenceByEducatorEmployeeId(educator.getEmployeeId());
        }
        if (student != null) {
            attendences = attendenceService.findAttendenceByGradeDesignation(student.getGrade().getDesignation());
        }        
        Facilities = facilityService.listAll();
        attendanceStatuses = Arrays.asList(AttendanceStatus.values());        
    }


    public void addOrUpdate(Attendence attend) {
        this.resetView(false).setAdd(true);
        if (attend != null) {
            attend.setUpdatedBy(getActiveUser().getIdentifier());
            attend.setUpdatedDate(new Date());
            attendence = attend;
        } else {
            attendence = new Attendence();
            attendence.setCreatedBy(getActiveUser().getIdentifier());
            attendence.setCreatedDate(new Date());
            attendence.setEducator(educator);

            attendences.add(0, attendence);
        }
    }

    public void save(Attendence attend) {
        if (attend.getId() != null) {
            attend.setUpdatedBy(getActiveUser().getIdentifier());
            attend.setUpdatedDate(new Date());
            attendenceService.update(attend);
        } else {
            attendenceService.save(attend);
        }
        this.resetView(false).setList(true);
    }

    public void delete(Attendence attend) {
        attendenceService.deleteById(attend.getId());
        synchronize(attend);
        this.resetView(false).setList(true);
    }

    public void synchronize(Attendence attend) {
        Iterator<Attendence> attenceList = attendences.iterator();
        while (attenceList.hasNext()) {
            if (attenceList.next().getId().equals(attend.getId())) {
                attenceList.remove();
            }
        }
    }

    public void cancel(Attendence attend) {
        if (attend.getId() == null) {
            if (attendences.contains(attend)) {
                attendences.remove(attend);
            }
        }
        this.resetView(false).setList(true);
    }

    public void attend(Attendence attend, Student stud) {
        attend.setUpdatedBy(getActiveUser().getIdentifier());
        attend.setUpdatedDate(new Date());
        attend.addStudent(stud);
        attendenceService.update(attend);
        this.resetView(false).setList(true);
    }

    public Attendence getAttendence() {
        return attendence;
    }

    public void setAttendence(Attendence attendence) {
        this.attendence = attendence;
    }

    public Employee getEducator() {
        return educator;
    }

    public void setEducator(Employee educator) {
        this.educator = educator;
    }

    public List<Facility> getFacilities() {
        return Facilities;
    }

    public void setFacilities(List<Facility> Facilities) {
        this.Facilities = Facilities;
    }

    public List<AttendanceStatus> getAttendanceStatuses() {
        return attendanceStatuses;
    }

    public void setAttendanceStatuses(List<AttendanceStatus> attendanceStatuses) {
        this.attendanceStatuses = attendanceStatuses;
    }

    public List<Attendence> getAttendences() {
        return attendences;
    }

    public void setAttendences(List<Attendence> attendences) {
        this.attendences = attendences;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<Attendence> getAllAttendences() {
        return allAttendences;
    }

    public void setAllAttendences(List<Attendence> allAttendences) {
        this.allAttendences = allAttendences;
    }

}
