/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import za.gov.sars.sms.domain.School;

/**
 *
 * @author S2026987
 */
public interface SchoolServiceLocal {
    School save(School school);

    School findById(Long id);

    School update(School school);

    void deleteAll();

    School deleteById(Long id);

    List<School> listAll();

    boolean isExist(School school);

    long count();
}
