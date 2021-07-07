/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import za.gov.sars.sms.domain.Subject;

/**
 *
 * @author S2026987
 */
public interface SubjectServiceLocal {
    Subject save(Subject subject);

    Subject findById(Long id);

    Subject update(Subject subjectemployee);

    void deleteAll();

    Subject deleteById(Long id);

    List<Subject> listAll();

    boolean isExist(Subject subject);

    long count();
}
