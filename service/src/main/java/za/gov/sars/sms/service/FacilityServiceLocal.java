/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import za.gov.sars.sms.domain.Facility;

/**
 *
 * @author S2026987
 */
public interface FacilityServiceLocal {
    Facility save(Facility facility);

    Facility findById(Long id);

    Facility update(Facility facility);

    void deleteAll();

    Facility deleteById(Long id);

    List<Facility> listAll();

    boolean isExist(Facility facility);

    long count();
}
