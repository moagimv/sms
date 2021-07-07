/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.gov.sars.sms.service;

import java.util.List;
import za.gov.sars.sms.domain.SchoolSystemUser;

/**
 *
 * @author S2026987
 */
public interface SystemUserServiceLocal {
    
    SchoolSystemUser login(String username);
    
    SchoolSystemUser findSystemUserByIdentifier(String identifier);
    
    SchoolSystemUser save(SchoolSystemUser systemUser);

    SchoolSystemUser findById(Long id);

    SchoolSystemUser update(SchoolSystemUser systemUser);

    void deleteAll();

    SchoolSystemUser deleteById(Long id);

    List<SchoolSystemUser> listAll();

    boolean isExist(SchoolSystemUser systemUser);

    long count();
}
