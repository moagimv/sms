/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.sars.sms.domain.Attendence;
import za.gov.sars.sms.persistence.AttendenceRepository;

/**
 *
 * @author S2026987
 */
@Service
public class AttendenceService implements AttendenceServiceLocal{

    @Autowired
    private AttendenceRepository attendenceRepository;
    @Override
    public Attendence save(Attendence attendence) {
        return attendenceRepository.save(attendence);
    }

    @Override
    public Attendence findById(Long id) {
        return attendenceRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public Attendence update(Attendence attendence) {
        return attendenceRepository.save(attendence);
    }

    @Override
    public void deleteAll() {
        attendenceRepository.deleteAll();
    }

    @Override
    public Attendence deleteById(Long id) {
        Attendence attendence = findById(id);
        if(attendence != null){
            attendenceRepository.deleteById(id);
        }
        return attendence;
    }

    @Override
    public List<Attendence> listAll() {
        return attendenceRepository.findAll();
    }

    @Override
    public boolean isExist(Attendence attendence) {
        return attendenceRepository.findById(attendence.getId()) != null;
    }

    @Override
    public long count() {
        return attendenceRepository.count();
    }
    
}
