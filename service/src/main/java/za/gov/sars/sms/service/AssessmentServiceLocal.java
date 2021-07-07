/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import za.gov.sars.sms.domain.Assessment;

/**
 *
 * @author S2026987
 */
public interface AssessmentServiceLocal {
    Assessment save(Assessment assessment);

    Assessment findById(Long id);

    Assessment update(Assessment assessment);

    void deleteAll();

    Assessment deleteById(Long id);

    List<Assessment> listAll();

    boolean isExist(Assessment assessment);

    long count();
}
