/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import za.gov.sars.sms.domain.Grade;

/**
 *
 * @author S2026987
 */
public interface GradeServiceLocal {
    Grade save(Grade grade);

    Grade findById(Long id);

    Grade update(Grade grade);

    void deleteAll();

    Grade deleteById(Long id);

    List<Grade> listAll();

    boolean isExist(Grade grade);

    long count();
}
