/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import za.gov.sars.sms.domain.Attendence;

/**
 *
 * @author S2026987
 */
public interface AttendenceServiceLocal {
    Attendence save(Attendence attendence);

    Attendence findById(Long id);

    Attendence update(Attendence attendence);

    void deleteAll();

    Attendence deleteById(Long id);

    List<Attendence> listAll();

    boolean isExist(Attendence attendence);

    long count();
}
