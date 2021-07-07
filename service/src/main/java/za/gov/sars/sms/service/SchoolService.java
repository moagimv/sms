/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.gov.sars.sms.domain.School;
import za.gov.sars.sms.persistence.SchoolRepository;

/**
 *
 * @author S2026987
 */
@Service
public class SchoolService implements SchoolServiceLocal {

    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public School save(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public School findById(Long id) {
        return schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                                "The requested id [" + id
                                + "] does not exist."));
    }

    @Override
    public School update(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public void deleteAll() {
        schoolRepository.deleteAll();
    }

    @Override
    public School deleteById(Long id) {
        School school = findById(id);
        if (school != null) {
            schoolRepository.deleteById(id);
        }
        return school;
    }

    @Override
    public List<School> listAll() {
        return schoolRepository.findAll();
    }

    @Override
    public boolean isExist(School school) {
        return schoolRepository.findById(school.getId()) != null;
    }

    @Override
    public long count() {
        return schoolRepository.count();
    }

}
