/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.Date;
import za.gov.sars.sms.common.AttendanceStatus;
import za.gov.sars.sms.domain.Attendence;
import za.gov.sars.sms.persistence.AttendenceRepository;

/**
 *
 * @author S2026987
 */
public class AttendenceHelper {
    
    public static void addAttendence(AttendenceRepository attendenceRepository){
        Attendence attendence1 = new Attendence();
        attendence1.setCreatedBy("test");
        attendence1.setCreatedDate(new Date());
        attendence1.setName("Mathematics Chapter 4 Lecture");
        attendence1.setDescription("A Mathematics Chapter 4 test cases attendence");
        attendence1.setStatus(AttendanceStatus.AVAILABLE);
        attendence1.setAttendanceDate(new Date());
        attendenceRepository.save(attendence1);
        
        Attendence attendence2 = new Attendence();
        attendence2.setCreatedBy("test");
        attendence2.setCreatedDate(new Date());
        attendence2.setName("Physical Science Chapter 8 Lecture");
        attendence2.setDescription("A Physical Science Chapter 8 test cases attendence");
        attendence2.setStatus(AttendanceStatus.CANCELLED);
        attendence2.setAttendanceDate(new Date());
        attendenceRepository.save(attendence2);
        
        Attendence attendence3 = new Attendence();
        attendence3.setCreatedBy("test");
        attendence3.setCreatedDate(new Date());
        attendence3.setName("Economics Chapter 1 Lecture");
        attendence3.setDescription("A Economics Chapter 1 test cases attendence");
        attendence3.setStatus(AttendanceStatus.POSTPONED);
        attendence3.setAttendanceDate(new Date());
        attendenceRepository.save(attendence3);
        
    }
}
